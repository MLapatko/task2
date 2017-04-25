<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>songs</title>
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<div>
    <input type="text" placeholder="Искать исполнителя">
    <button class="js-action-search-singer">Искать</button>
</div>
<table id="solo" class="display" cellspacing="0" width="100%" >
    <thead>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>Композитор</th>
        <th>Время</th>
        <th>Автор слов</th>
        <th>Исполнитель</th>
        <th>Аккомпанемент</th>
        <th>Тип вокала</th>
        <th>Записать на диск</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>Композитор</th>
        <th>Время</th>
        <th>Автор слов</th>
        <th>Исполнитель</th>
        <th>Аккомпанемент</th>
        <th>Тип вокала</th>
        <th>Записать на диск</th>
        <th></th>
        <th></th>
    </tr>
    </tfoot>
    <tbody>
    </tbody>
</table>
<table id="chorus" class="display" cellspacing="0" width="100%" >
    <thead>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>Композитор</th>
        <th>Время</th>
        <th>Автор слов</th>
        <th>Исполнитель</th>
        <th>Аккомпанемент</th>
        <th>Тип хора</th>
        <th>Записать на диск</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>Композитор</th>
        <th>Время</th>
        <th>Автор слов</th>
        <th>Исполнитель</th>
        <th>Аккомпанемент</th>
        <th>Тип хора</th>
        <th>Записать на диск</th>
        <th></th>
        <th></th>
    </tr>
    </tfoot>
    <tbody>
    </tbody>
</table>
<button class="js-action-sort-name">Сортировать по имени</button>
<button class="js-action-calculate-time">Общее время на диске</button>
<script src="<c:url value="/resources/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/js/songs.js"/>"></script>
</body>
</html>
