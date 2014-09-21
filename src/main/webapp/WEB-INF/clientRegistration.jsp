<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:bundle basename="massages.properties">
    <html>
    <style>
        <%@include file='../static/style/registration.css' %>
    </style>
    <head>
        <title>client Registration</title>
        <!-- Res -->
        <script type="text/javascript" src="/static/res/x5engine.js"></script>
        <link rel="stylesheet" type="text/css" href="/static/res/styles.css" media="screen, print" />
        <link rel="stylesheet" type="text/css" href="/static/res/template.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="/static/res/print.css" media="print" />
        <!--[if lt IE 7]><link rel="stylesheet" type="text/css" href="/static/res/iebehavior.css" media="screen" /><![endif]-->
        <link rel="stylesheet" type="text/css" href="/static/res/imcart.css" media="screen, print" />
        <%--<script type="text/javascript" src="/static/res/x5cart.js"></script>--%>
        <link rel="stylesheet" type="text/css" href="/static/res/handheld.css" media="handheld" />
        <link rel="alternate stylesheet" title="Высокий контраст - Доступность" type="text/css" href="/static/res/accessibility.css" media="screen" />
        <script type="text/javascript" src="/static/res/x5products.js"></script>


    </head>
    <body>

                             <h2>Регистрация</h2>

                    <div id="imCartText">Пожалуйста, заполните следующую форму.<br/>Заполняйте все необходимые
                        поля.<br/>Для перехода нажмите кнопку 'Далее'.
                        <form class="imUserData" name="imFormTableDat" value="clientRegistration" method="post" onsubmit="return ChkFrm(this)"
                              action="">
                            <fieldset>
                                <div>
                                        <%--@declare id="itm_1"--%><label for="Itm_1">
                                    <span class="imLabel">Логин*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_0" type="text" name="imTxtDat"  id="Itm1"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_2"--%><label for="Itm_2">
                                    <span class="imLabel">Адрес*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_0" type="text" name="imTxtDat" id="Itm2"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_3"--%><label for="Itm_3">
                                    <span class="imLabel">Город*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_0" type="text" name="imTxtDat" id="Itm3"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_4"--%><label for="Itm_4">
                                    <span class="imLabel">Фамилия*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_3" type="text" name="imTxtDat" id="Itm4"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_5"--%><label for="Itm_5">
                                    <span class="imLabel">Область*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_2" type="text" name="imTxtDat" id="Itm5"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_6"--%><label for="Itm_6">
                                    <span class="imLabel">Регион*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_0" type="text" name="imTxtDat" id="Itm6"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_7"--%><label for="Itm_7">
                                    <span class="imLabel">Страна*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_1" type="text" name="imTxtDat" id="Itm7"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_8"--%><label for="Itm_8">
                                    <span class="imLabel">Телефон*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_2" type="text" name="imTxtDat" id="Itm8"/>
</span>
                                </label>
                                </div>
                                <div>
                                        <%--@declare id="itm_16"--%><label for="Itm_16">
                                    <span class="imLabel">e-mail*:<br class="imHidden"/></span>
<span class="imLabel_Cont">
<input class="imField imInput_1" type="text" name="imTxtDat" id="Itm16"/>
</span>
                                </label>
                                </div>

                                <div class="imAlign_center">

                                    <input class="imCartButton" type="submit" value="Зарегистрировать"/>
                                </div>
                            </fieldset>
                        </form>
                        <script type="text/javascript"><!--
                        imCGetUserData();
                        function ChkFrm(oForm) {
                            sAlert1 = "Отсутствует значение поля ";
                            sAlert2 = "Неверное значение e-mail для поля ";
                            if (oForm.imTxtDat[0].value == "") {
                                oForm.imTxtDat[0].focus();
                                alert(sAlert1 + "'Логин'");
                                return (false);
                            }
                            if (oForm.imTxtDat[1].value == "") {
                                oForm.imTxtDat[1].focus();
                                alert(sAlert1 + "'Адрес'");
                                return (false);
                            }
                            if (oForm.imTxtDat[2].value == "") {
                                oForm.imTxtDat[2].focus();
                                alert(sAlert1 + "'Город'");
                                return (false);
                            }
                            if (oForm.imTxtDat[3].value == "") {
                                oForm.imTxtDat[3].focus();
                                alert(sAlert1 + "'Фамилия'");
                                return (false);
                            }
                            if (oForm.imTxtDat[4].value == "") {
                                oForm.imTxtDat[4].focus();
                                alert(sAlert1 + "'Область'");
                                return (false);
                            }
                            if (oForm.imTxtDat[5].value == "") {
                                oForm.imTxtDat[5].focus();
                                alert(sAlert1 + "'Регион'");
                                return (false);
                            }
                            if (oForm.imTxtDat[6].value == "") {
                                oForm.imTxtDat[6].focus();
                                alert(sAlert1 + "'Страна'");
                                return (false);
                            }
                            if (oForm.imTxtDat[7].value == "") {
                                oForm.imTxtDat[7].focus();
                                alert(sAlert1 + "'Телефон'");
                                return (false);
                            }
                            if (oForm.imTxtDat[8].value == "" || oForm.imTxtDat[8].value.indexOf('@', 0) < 1 || oForm.imTxtDat[8].value.indexOf('.', 0) < 1) {
                                oForm.imTxtDat[8].focus();
                                alert(sAlert2 + "'e-mail'");
                                return (false);
                            }
                            return (true);
                        }
                        //--></script>
                        </div>
                        <div id="messenger"></div>





    </body>
    </html>
</fmt:bundle>
