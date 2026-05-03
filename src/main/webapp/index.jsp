<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits MVC1</title>
</head>
<body>

    <h2>Gestion des Produits (MVC1)</h2>
    &nbsp;&nbsp; <a href="logout">Déconnexion</a>

    <hr/>

    <c:if test="${not empty messageSucces}">
        <p style="color:green;">${messageSucces}</p>
    </c:if>
    <c:if test="${not empty messageErreur}">
        <p style="color:red;">${messageErreur}</p>
    </c:if>
    <c:if test="${not empty messageInfo}">
        <p style="color:orange;">${messageInfo}</p>
    </c:if>
    <c:if test="${not empty param.erreur}">
        <p style="color:red;">${param.erreur}</p>
    </c:if>

    <hr/>

    <form action="${not empty produitEdit ? 'updateProduit' : 'addProduit'}" method="post">

        <input type="hidden" name="idProduit" value="${produitEdit.idProduit}" />

        Nom: <input type="text" name="nom" value="${produitEdit.nom}" required />
        Description: <input type="text" name="description" value="${produitEdit.description}" required />
        Prix: <input type="text" name="prix" value="${produitEdit.prix}" required />

        <input type="submit" value="${not empty produitEdit ? 'Modifier' : 'Ajouter'}" />

        <c:if test="${not empty produitEdit}">
            <a href="listProduits">Annuler</a>
        </c:if>

    </form>

    <hr/>

    <form action="listProduits" method="get">
        ID: <input type="text" name="idProduit" />
        <input type="submit" value="Rechercher" />
    </form>

    <hr/>
    
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Actions</th>
        </tr>
        <c:choose>
            <c:when test="${empty listeProduits}">
                <tr>
                    <td colspan="5" align="center">Aucun produit trouvé.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="p" items="${listeProduits}">
                    <tr>
                        <td>${p.idProduit}</td>
                        <td>${p.nom}</td>
                        <td>${p.description}</td>
                        <td>${p.prix}</td>
                        <td>
                            <a href="editProduit?id=${p.idProduit}">Modifier</a>
                            |
                            <a href="deleteProduit?id=${p.idProduit}"
                               onclick="return confirm('Supprimer ce produit ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>

</body>
</html>