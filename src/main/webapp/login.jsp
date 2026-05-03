<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
    <h2>Connexion – Gestion des Produits (MVC1)</h2>
    <c:if test="${not empty erreurLogin}">
        <p style="color:red;">${erreurLogin}</p>
    </c:if>

    <form action="login" method="post">
        Login : <input type="text" name="login" required /> <br/><br/>
        Mot de passe : <input type="password" name="password" required /> <br/><br/>
        <input type="submit" value="Se connecter" />
    </form>
</body>
</html>