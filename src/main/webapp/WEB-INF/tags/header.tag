<%@tag description="authentication template" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <%--<!-- Menu END -->--%>