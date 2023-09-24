<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet"
              type="text/css" href="<@spring.url '/css/style.css'/>"/>
    </head>

    <body>
    <h1>+++++++ORCHESTRA+++++++++++++++++</h1>
    <br>
    <div>
            <table border="4">
                <thead>
                <th>id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Delete</th>
                <th>Update</th>
                </thead>
                <#list items as item>
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td> <a href="/ui/v1/orchestra/del/${item.id}">Delete</a> </td>
                        <td><button>Edit</button></td>

                    </tr>
                </#list>

            </table>
        </div>
    </body>
</html>
