<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sample car venda</title>
    <style>
        .title {
            margin-bottom: 30px;
            font-size: 20px;
        }
        
        .igual {
            text-align: left;
        }
        
        .igual .label{
            display: inline-block;
            margin-bottom: 15px;
            width: 140px;
        }
        
        .center {
            display: flex;
            flex-direction: row;
            width: 100%;
        }
        
        .flex {
            flex-grow: 1;
        }
        
        html{
                font-family: "Arial"; 
                
            }
        h1   {color: graytext;}
        p    {color: red;}
        .borda {
            border: black 1px solid;
            width: 550px;
            margin: auto;
            background-color: #ffffff;
        }
        body{
            background-image: url(img/download.jpg);
            background-size:cover;
        }
    </style>
</head>
<body>
    <div class="borda">
        <center>
            <h1>Venda de veículo</h1>
            <h2>
                <a href="/samplecar/list">
                    <button>
                        Listar Veículos
                    </button>
                </a>
            </h2>
        </center>
        <div align="center">
            <c:if test="${venda != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${venda == null}">
                <form action="insert" method="post">
            </c:if>

            <c:if test="${venda != null}">
                Editar a venda
            </c:if>
            <c:if test="${venda == null}">
                <div class="title">Adicionar nova venda</div>
            </c:if>

            <c:if test="${venda != null}">
                <input type="hidden" name="id" value="<c:out value='${venda.id}' />" />
            </c:if>   

            <div class="center">
                <div class="flex"></div>
                <div>
                    <div class="igual">  
                        <div class="label">Nome Cliente</div>
                        <input type="text" name="title" size="45" required
                            value="<c:out value='${venda.nome_cliente}' />"
                        />
                    </div>

                    <div class="igual">
                        <div class="label">Nome Vendedor</div>
                        <input type="text" name="author" size="45" required
                             value="<c:out value='${venda.nome_vendedor}' />"
                        />
                    </div>

                    <div class="igual">
                        <div class="label">Preço <b>(R$)</b></div>
                        <input type="number" name="price" size="5" required
                             value="<c:out value='${venda.preco_venda}' />"
                        />
                    </div>

                        <div class="center">
                            <div class="flex"></div>
                            <input type="submit" value="Save" />
                            <div class="flex"></div>
                        </div>
                </div>
                <div class="flex"></div>
            </div>
        </div>  
    </div>
</body>
</html>
