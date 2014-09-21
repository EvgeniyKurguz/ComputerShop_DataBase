<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Компьютерный магазин</title>
    <link rel="stylesheet" href="../static/style/style.css">
    <!-- Contents -->
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <meta http-equiv="Content-Language" content="ru"/>
    <meta http-equiv="last-modified" content="21.08.2014 00:21:03"/>
    <meta http-equiv="Content-Type-Script" content="text/javascript"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <!-- imCustomHead -->
    <meta http-equiv="Expires" content="0"/>
    <meta name="Resource-Type" content="document"/>
    <meta name="Distribution" content="global"/>
    <meta name="Robots" content="index, follow"/>
    <meta name="Revisit-After" content="21 days"/>
    <meta name="Rating" content="general"/>
    <!-- Others -->
    <meta name="Generator" content="Incomedia WebSite X5 Evolution 8.0.11 - www.websitex5.com"/>
    <meta http-equiv="ImageToolbar" content="False"/>
    <meta name="MSSmartTagsPreventParsing" content="True"/>

    <!-- Parent -->
    <link rel="sitemap" href="/static/imsitemap.html" title="Общая карта сайта"/>
    <!-- Res -->
    <script type="text/javascript" src="/static/res/x5engine.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/res/styles.css" media="screen, print"/>
    <link rel="stylesheet" type="text/css" href="/static/res/template.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="/static/res/print.css" media="print"/>
    <!--[if lt IE 7]>
    <link rel="stylesheet" type="text/css" href="/static/res/iebehavior.css" media="screen"/><![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/res/home.css" media="screen, print"/>
    <script type="text/javascript" src="/static/res/x5cart.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/res/handheld.css" media="handheld"/>
    <link rel="alternate stylesheet" title="Высокий контраст - Доступность" type="text/css"
     href="/static/res/accessibility.css" media="screen"/>

</head>
<body>
<%--<%--%>
    <%--response.sendRedirect(request.getContextPath()+"/login");--%>
<%--%>--%>
<div id="imSite">
<c:if test="${empty user}">
<form  action="<c:url value="/login"/>" method="post">
        <h3 align="right"><span><em><strong> Вход в личный кабинет. </strong></em></span></h3>
        <input name="action" type="hidden" value="login"/>

        <div align="right"> Имя:
            <input type="text" name="username" placeholder="Username"/>
        </div>

        <p align="right"><span class="content">	Пароль:
              <input type="password" name="password" placeholder="Password"/>
          </span></p>

        <div align="right">
            <%--<a class="c" href="home" >ВОЙТИ</a>--%>
            <button type="submit" class="">Войти</button>--%>
            <a href="clientRegistration" class="c">РЕГИСТРАЦИЯ</a>
         </div>
    </form>
</c:if>
    <%--<c:if test="${empty user}">--%>
        <%--<ul class="nav pull-right">--%>
            <%--<li class="dropdown">--%>
                <%--<a data-toggle="dropdown" class="dropdown-toggle" href="#">Login <b class="caret"></b></a>--%>

                <%--<div class="dropdown-menu">--%>
                    <%--<form class="form-horizontal loginFrm" action="<c:url value="/login"/>" method="post">--%>

                        <%--<div class="control-group">--%>
                            <%--<input type="text" class="span2" name="username" placeholder="Username">--%>
                        <%--</div>--%>
                        <%--<div class="control-group">--%>
                            <%--<input type="password" class="span2" name="password" placeholder="Password">--%>
                        <%--</div>--%>
                        <%--<div class="control-group">--%>
                            <%--<label class="checkbox">--%>
                                <%--<input type="checkbox"> Remember me--%>
                            <%--</label>--%>
                            <%--<button type="submit" class="btn pull-right">Sign in</button>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>
            <%--</li>--%>
            <%--<form style="float: right">--%>

                        <%--<a href="clientRegistration" class="c">Зарегистрироваться</a>--%>

            <%--</form>--%>
        <%--</ul>--%>
    <%--</c:if>--%>
<%-----End---%>
        <%--<form action="" method="post">--%>
            <%--Логин: <input type="text" name="user" size="10"><br>--%>
            <%--Пароль: <input type="password" name="password" size="10"><br>--%>
            <%--<p>--%>
            <%--<table>--%>
                <%--<tr>--%>
                    <%--<th><small>--%>
                        <%--<input type="submit" name="логин" value="Войти в систему">--%>
                    <%--</small>--%>
                    <%--<th><small>--%>
                        <%--<input type="submit" name="registration" value="Зарегистрироваться">--%>
                    <%--</small>--%>
            <%--</table>--%>
        <%--</form>--%>

    <div id="imHeader">

        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
                codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0"
                width="992" height="147">
            <param name="movie" value="/static/res/top.swf"/>
            <param name="menu" value="false"/>
            <param name="quality" value="high"/>
            <param name="wmode" value="opaque"/>
            <param name="flashvars" value="txt=Магазин компьютеров"/>
            <!--[if !IE]> <-->
            <object type="application/x-shockwave-flash" width="992" height="147" data="/static/res/top.swf">
                <param name="menu" value="false"/>
                <param name="quality" value="high"/>
                <param name="wmode" value="opaque"/>
                <param name="flashvars" value="txt=Магазин компьютеров"/>
            </object>
            <!--> <![endif]-->
        </object>
        <h1>Магазин компьютеров</h1>
    </div>
    <div class="imInvisible">
        <hr/>
        <a href="#imGoToCont" title="Пропустить главное меню">Перейти к содержанию</a>
    </div>
    <div id="imBody">
        <div id="imMenuMain">

            <!-- Menu START -->
            <a name="imGoToMenu"></a>

            <p class="imInvisible">Главное меню:</p>

            <div id="imMnMn">
                <ul>
                    <li><a class="imMnItm_1" title=""><span class="imHidden">Главная</span></a></li>
                    <li><a class="imMnItm_2"><span class="imHidden">Компьютеры, Ноутбуки, Игровые приставки</span></a>
                        <ul>
                            <li><a href="ноутбуки.html" title="">Ноутбуки</a></li>
                            <li><a href="настольные_пк.html" title="">Настольные ПК</a></li>
                            <li><a href="ультрабуки.html" title="">Ультрабуки</a></li>
                            <li><a href="игровые_приставки.html" title="">Игровые приставки</a></li>
                            <li><a href="моноблоки.html" title="">Моноблоки</a></li>
                            <li><a href="серверы.html" title="">Серверы</a></li>
                        </ul>
                    </li>
                    <li><a class="imMnItm_3"><span class="imHidden">Мобильные устройства</span></a>
                        <ul>
                            <li><a href="планшеты.html" title="">Планшеты</a></li>
                            <li><a href="смартфоны.html" title="">Смартфоны</a></li>
                            <li><a href="электронные_книги.html" title="">Электронные книги</a></li>
                            <li><a href="gps-навигаторы_радар-детекторы.html" title="">GPS-навигаторы,
                                радар-детекторы</a></li>
                        </ul>
                    </li>
                    <li><a class="imMnItm_4"><span class="imHidden">Комплектующие</span></a>
                        <ul>
                            <li><a href="процессоры.html" title="">Процессоры</a></li>
                            <li><a href="видеокарты.html" title="">Видеокарты</a></li>
                            <li><a href="материнские_платы.html" title="">Материнские платы</a></li>
                            <li><a href="оперативная_память.html" title="">Оперативная память</a></li>
                            <li><a href="жесткие_диски.html" title="">Жесткие диски</a></li>
                            <li><a href="блоки_питания.html" title="">Блоки питания</a></li>
                            <li><a href="корпуса.html" title="">Корпуса</a></li>
                        </ul>
                    </li>
                    <li><a class="imMnItm_5"><span class="imHidden">Периферия</span></a>
                        <ul>
                            <li><a href="мониторы_жидкокристалические.html" title="">Мониторы жидкокристалические</a>
                            </li>
                            <li><a href="принтеры_струйные.html" title="">Принтеры струйные</a></li>
                            <li><a href="принтеры_лазерные.html" title="">Принтеры лазерные</a></li>
                            <li><a href="сканеры.html" title="">Сканеры</a></li>
                            <li><a href="факсы_телефоны.html" title="">Факсы, телефоны</a></li>
                        </ul>
                    </li>
                    <li><a class="imMnItm_6"><span class="imHidden">Манипуляторы</span></a>
                        <ul>
                            <li><a href="клавиатуры.html" title="">Клавиатуры</a></li>
                            <li><a href="мыши.html" title="">Мыши</a></li>
                            <li><a href="джойстики_рули.html" title="">Джойстики, рули</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- Menu END -->

        </div>
        <hr class="imInvisible"/>
        <a name="imGoToCont"></a>

        <div id="imContent">

            <!-- Page START -->
            <div id="imPage">

                <div id="imCel6_00">
                    <div id="imCel6_00_Cont">
                        <div id="imObj6_00">
                            <div id="imSSCont_0">
                                <div id="imSSBackg_0" onmouseover="imSSDescrHide(0);" onmouseout="imSSDescrShow(0);">
                                    <div id="imSSImages_0">
                                        <img id="imSSImage_0" src="/static/slideshow/home_0_1.jpg" onclick="imLink(0);"
                                             alt="" style="opacity: 1"/>
                                        <img id="imSSImage_0_back" src="" onclick="imLink(0);" alt=""
                                             style="opacity: 0; display: none;"/>
                                    </div>
                                    <div id="imSSDescr_0" style="display: none; bottom: 0;">
                                        <div id="imSSDescr_0_content">
                                            <div id="imSSDescr_0_bg"></div>
                                            <div id="imSSDescr_0_text"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="imSSBtns_0"><img src="/static/res/ss_left4.gif" alt=""/><img class="imssBtn"
                                                                                                  src="/static/res/ss_fullscreen4.gif"
                                                                                                  onclick="javascript:imPopUpWin('fullscreen',-1,-1,'no','no');"
                                                                                                  alt="На весь экран"/><img
                                    class="imssBtn" src="/static/res/ss_prev4.gif" onclick="imDoTrans(0,-1)"
                                    alt="Далее"/><img class="imssBtn" src="/static/res/ss_play4.gif" id="imssPlay_0"
                                                      onclick="imSSPlay(0,0,4)" alt="Play"/><img class="imssBtn"
                                                                                                 src="/static/res/ss_next4.gif"
                                                                                                 onclick="imDoTrans(0,1)"
                                                                                                 alt="Назад"/><img
                                    src="/static/res/ss_right4.gif" alt=""/></div>
                            <script type="text/javascript">
                                imSSLoad(0, [
                                    ["home_0_1.jpg", 304, 225, 3, 13, "", "#"],
                                    ["home_0_2.jpg", 304, 228, 3, 13, "", "#"],
                                    ["home_0_3.jpg", 274, 228, 3, 13, "", "#"],
                                    ["home_0_4.jpg", 255, 228, 3, 13, "", "#"],
                                    ["home_0_5.jpg", 304, 184, 3, 13, "", "#"],
                                    ["home_0_6.jpg", 303, 228, 3, 13, "", "#"],
                                    ["home_0_7.jpg", 304, 210, 3, 13, "", "#"],
                                    ["home_0_8.jpg", 227, 228, 3, 13, "", "#"],
                                    ["home_0_9.jpg", 304, 190, 3, 13, "", "#"]
                                ]);
                                imLoadList += "imDoTrans(0,0);";
                            </script>
                        </div>
                    </div>
                </div>

            </div>
            <!-- Page END -->

        </div>
        <div id="imFooter">
            <div style="position: absolute; left: 810px; top: 21px; width: 152px; height: 21px; ">
                <form id="imSearch_11" action="imsearch.php" method="get" style="white-space: nowrap">
                    <fieldset><input type="text" name="search" value=""
                                     style="width: 75px; font: 11px Tahoma; color: #000000; background: #FFFFFF url('/static/res/imsearch.gif') no-repeat 3px; padding: 3px 3px 3px 21px; border: 1px solid #000000; vertical-align: middle"/> <span
                            style="font: 11px Tahoma; color: #000000; background-color: #808080; padding: 3px 6px 3px 6px; border: 1px solid #000000; vertical-align: middle; cursor: pointer; "
                            onclick="alert('Команда поиска доступна, только если вебсайт опубликован.'); return false;">Поиск</span>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="imInvisible">
    <hr/>
    <a href="#imGoToCont" title="Просмотреть страницу еще раз">Назад к содержанию</a> | <a href="#imGoToMenu"
                                                                                           title="Просмотреть сайт еще раз">Назад
    к главному меню</a>
</div>


<div id="imShowBoxBG" style="display: none;" onclick="imShowBoxHide()"></div>
<div id="imShowBoxContainer" style="display: none;" onclick="imShowBoxHide()">
    <div id="imShowBox" style="height: 200px; width: 200px;"></div>
</div>
<div id="imBGSound"></div>
<div id="imToolTip">
    <script type="text/javascript">var imt = new IMTip;</script>
</div>
<script type="text/javascript">imPreloadImages('/static/res/immnu_01b.gif,/static/res/immnu_02b.gif,res/immnu_03b.gif,res/immnu_04b.gif,res/immnu_05b.gif,res/immnu_06b.gif')</script>
</body>
</html>
