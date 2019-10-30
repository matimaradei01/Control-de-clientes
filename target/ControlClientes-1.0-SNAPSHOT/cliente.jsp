<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Control de Clientes</h1>

        <c:forEach var="lista" items="lista">
            <c:out value = "${lista.nombre}"/><p>
        </c:forEach>
       
    </body>
</html>
