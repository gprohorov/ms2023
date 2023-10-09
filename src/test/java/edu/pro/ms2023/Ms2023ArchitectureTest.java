package edu.pro.ms2023;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   ms2023
  @class  Ms2023ArchitectureTest
  @version  1.0.0 
  @since 02.10.23 - 11.48
*/
@SpringBootTest
class Ms2023ArchitectureTest {
    private JavaClasses importedClasses;

    @BeforeEach
    void init(){
        importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("edu.pro.ms2023");
    }

    @Test
    void testFollowingLayersArchitecture(){
        layeredArchitecture()
                .consideringAllDependencies()
                .layer("Controller").definedBy("..controller")
                .layer("Service").definedBy("..service")
                .layer("Repository").definedBy("..repository")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                .check(importedClasses);

    }

    @Test
    void controllerClassesSholdHaveNamesXController() {
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .haveSimpleNameEndingWith("Controller")
                .check(importedClasses);
    }

    @Test
    void checkControllersAnnotations(){
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .beAnnotatedWith(RestController.class)
                .orShould()
                .beAnnotatedWith(Controller.class)
                .check(importedClasses);
    }
    @Test
    void checkControllersAnnotationRequestMapping(){
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .beAnnotatedWith(RequestMapping.class)
                .check(importedClasses);
    }
//
//    @Test
//    void testAutowiredAnnotation(){
//        noFields()
//                .should()
//                .beAnnotatedWith(Autowired.class)
//                .check(importedClasses);
//    }
//

}
