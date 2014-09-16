<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Магазин компьютеров</title>

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

    <%--Style--%>
    <link rel="stylesheet" href="../static/style/style.css">
    <!-- Parent -->
    <link rel="sitemap" href="imsitemap.html" title="Общая карта сайта"/>
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
<form method="post" name="login-form" action="">
<div align="right">

    <a href="login" class="c">Выйти</a>
    <a href="clientTable" class="c">Таблица клиентов</a>
    <a href="productTable" class="c">Таблица товаров</a>

</div>
    </form>

    <div id="imSite">
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
                        <li><a class="imMnItm_1" href="login" title=""><span class="imHidden">Главная</span></a></li>
                        <li><a class="imMnItm_2"><span
                                class="imHidden">Компьютеры, Ноутбуки, Игровые приставки</span></a>
                            <ul>
                                <li><a href="laptop" title="">Ноутбуки</a></li>
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
                                <li><a href="мониторы_жидкокристалические.html" title="">Мониторы
                                    жидкокристалические</a></li>
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

                </div>
                <!-- Page END -->

            </div>
            <div id="imFooter">
                <div style="position: absolute; left: 810px; top: 21px; width: 152px; height: 21px; ">
                    <form id="imSearch_11" action="imsearch.php" method="get" style="white-space: nowrap">
                        <fieldset><input type="text" name="search" value="" style="width: 75px; font: 11px
                    Tahoma; color: #000000; background: #FFFFFF url('/static/res/imsearch.gif')
                    no-repeat 3px; padding: 3px 3px 3px 21px; border: 1px solid #000000; vertical-align: middle"/>
                        <span style="font: 11px Tahoma; color: #000000; background-color: #808080;
                        padding: 3px 6px 3px 6px; border: 1px solid #000000; vertical-align: middle; cursor: pointer; "
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
    <script type="text/javascript">imPreloadImages('res/immnu_01b.gif,res/immnu_02b.gif,res/immnu_03b.gif,res/immnu_04b.gif,res/immnu_05b.gif,res/immnu_06b.gif')</script>
</body>
</html>
