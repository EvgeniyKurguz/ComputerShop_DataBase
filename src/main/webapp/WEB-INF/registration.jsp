<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Страница регистрации</title>
    <link rel="stylesheet" href="../static/style/style.css">
</head>

<body>
<form name="forma1">
    <table border="0" cellspacing="5" cellpadding="5">
        <caption>Форма регистрации</caption>
        <tr>
            <td align="right" valign="top">Имя</td>
            <td><input type="text" name="name" size="25"></td>
        </tr>
        <tr>
            <td align="right" valign="top">e-mail</td>
            <td><input type="text" name="e-mail" size="25"></td>
        </tr>
        <tr>
            <td align="right" valign="top">Пароль</td>
            <td>
                <input type="password" name="password" size="25">
            </td>
        </tr>
        <tr>
            <td align="right" valign="top">Повтор пароля</td>
            <td>
                <input type="password" name="password2" size="25">
            </td>
        </tr>
        <tr>
            <td align="right" valign="top">Пол</td>
            <td>
                <input type="radio" name="sex" value="man" checked>
                мужской
                <input type="radio" name="sex" value="woman">
                женский
            </td>
        </tr>
        <tr>
            <td align="right" valign="top">Увлечения</td>
            <td><select name="hobby" size="6" multiple>
                <option selected value="1">компьютеры
                <option value="2">спорт
                <option value="3">игры
                <option value="4">автомобили
                <option value="5">музыка
                <option value="6">наука
            </select>
            </td>
        </tr>
        <tr>
            <td align="right" valign="top">Ваши пожелания</td>
            <td>
                <textarea cols="30" rows="3" wrap="physical">
                </textarea>
            </td>
        </tr>
        <tr>
            <td align="right" colspan="2">
                <input type="submit" name="submit" value="Отправить">
                <input type="reset" name="reset" value="Очистить">
            </td>
        </tr>
    </table>
</form>
</body>
</html>