<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
</head>
<body>
    <h2>Une erreur est survenue</h2>
    <%
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = (String) request.getAttribute("javax.servlet.error.message");
    %>

    <p>Code erreur : <%= code %></p>

    <% if (message != null && !message.isEmpty()) { %>
        <p>Détail : <%= message %></p>
    <% } else { %>
        <p>Une erreur inattendue s'est produite.</p>
    <% } %>

    <a href="listProduits">Retour à l'accueil</a>

</body>
</html>