<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sample car venda</title>
</head>
<body>
    <center>
        <h1>Venda de veículo</h1>
        <h2>
            <a href="/samplecar/list">Listar veículos</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${venda != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${venda == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${venda != null}">
                        Editar a venda
                    </c:if>
                    <c:if test="${venda == null}">
                        Adicionar nova venda
                    </c:if>
                </h2>
            </caption>
                <c:if test="${venda != null}">
                    <input type="hidden" name="id" value="<c:out value='${venda.id}' />" />
                </c:if>           
            <tr>
                <th>Nome do cliente: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${venda.nome_cliente}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Nome vendedor: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${venda.nome_vendedor}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Preço de venda: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${venda.preco_venda}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
