<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    <%@include file='../static/css/registration.css' %>
</style>
<head>
    <title>client Registration</title>

</head>
<body>

<form method="post">
    <input type="hidden" name="action" value="clientRegistration">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td class="bdrform_tabl">
                <form class="formreg" action="" method="post" enctype="multipart/form-data">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="bdr_w">
                        <tr valign="top">
                            <td colspan="5"><span class="serdop">Внимание! Поля, отмеченные знаком
<span class="zvzd">&#0042;</span> &ndash; обязательны для заполнения</span>
                                <br><br></td>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td width="23%">
                                Уникальное имя (логин):
                            </td>
                            <td width="38%">
                                <input type="text" class="fld" id="username" name="username">
                                ${loginError}
                                ${loginRegexError}</td>
                            <td>&nbsp;&ndash;</td>
                            <td width="39%">Выбранное Вами имя может состоять из букв латинского алфавита или
                                кириллицы различного регистра, цифр и знака минус (-), и должно быть длиной от 5
                                до 15 символов. Пример: (<em>YakovShmidt</em>)
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td class="bt1">
                                Рабочий E-mail:
                            </td>
                            <td class="bt1">
                                <input name="email" id="email" type="email" class="fld" value="">${emailRegexError}
                            </td>
                            <td> &nbsp;&ndash;</td>
                            <td class="bt1">На этот почтовый адрес будет выслан пароль, если Вы его забудете.
                                Рекомендую заполнить это поле действительным адресом электронной почты,
                                на сайте проходит активация аккаунта через e-mail.
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd"></span>
                            </td>
                            <td class="bt1">
                                Ваше Имя:
                            </td>
                            <td class="bt1">
                                <input name="firstName" id="firstName" type="firstName" class="fld"
                                       value="">${emailRegexError}</td>
                            <td> &nbsp;&ndash;</td>
                            <td class="bt1">Здесть должно быть введенно ваше имя
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd"></span>
                            </td>
                            <td class="bt1">
                                Фамилия:
                            </td>
                            <td class="bt1">
                                <input name="lastName" id="lastName" type="lastName" class="fld"
                                       value="">${emailRegexError}</td>
                            <td> &nbsp;&ndash;</td>
                            <td class="bt1">Здесь должна быть введенна ваша фамилия.
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td class="bt1">
                                Пароль:
                            </td>
                            <td class="bt1">
                                <input name="password" type="password" id="password"
                                       class="fld"/>${passwordRegexError}
                            </td>
                            <td class="bt1" rowspan="2">
                                &nbsp;&ndash;
                            </td>
                            <td class="bt1" rowspan="2">
                                Пароль должен состоять не менее, чем из 8 и не более, чем из 20 знаков, содержать
                                цифры,
                                заглавные и/или прописные буквы латинского алфавитаю
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td>Повторите пароль:</td>
                            <td>
                                <input type="password" name="confirmPassword" id="confirmPassword" class="fld"
                                       value=""/>${passwordError}
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td>Дата рождения:</td>
                            <td>
                                <input type="date" name="birth" id="birth" class="fld" value=""/>${birthRegexError}
                            </td>
                            <td class="bt1" rowspan="2">
                                &nbsp;&ndash;
                            </td>
                            <td class="bt1" rowspan="2">
                                В это поле нужно ввести вашу дату рождения.
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd"></span>
                            </td>
                            <td class="bt1">
                                Номер телефона:
                            </td>
                            <td class="bt1">
                                <input name="phone" id="phone" type="phone" class="fld" value=""></td>
                            <td></td>
                            <td class="bt1">
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd"></span>
                            </td>
                            <td class="bt1">
                                Номер удостоверения:
                            </td>
                            <td class="bt1">
                                <input name="attestation_number" id="attestation_number" type="attestation_number"
                                       class="fld" value="">${emailRegexError}</td>
                            <td></td>
                            <td width="39%">
                            </td>
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td class="bt1">
                                Страна:
                            </td>
                            <td class="bt1">
                                <select name="country" id="country" class="fld">
                                    <option value="1">Kazakhstan</option>
                                    <option value="2">Russia</option>
                                </select>
                            </td>
                            <td class="bt1" rowspan="2">

                            </td>
                            <td class="bt1" rowspan="2">
                            </td>
                        </tr>
                        <tr valign="top">
                            <td>
                                <span class="zvzd">&#0042;</span>
                            </td>
                            <td class="bt1">
                                Город:
                            </td>
                            <td class="bt1">
                                <select name="city" id="city" class="fld">
                                    <option value="1">Astana</option>
                                    <option value="2">Moscow</option>
                                </select>
                            </td>
                            <td class="bt1" rowspan="2">
                                <%--&nbsp;&ndash;--%>
                            </td>
                            <td class="bt1" rowspan="2">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5" align="center">
                                <input type=submit value="Зарегистрировать" id="btnbk_reg">
                            </td>
                        </tr>
                    </table>
                </form>
                <div id="messenger"></div>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
