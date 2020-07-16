<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <#list menus as menu>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="${menu.name}">&#xe6b8;</i>
                        <cite>${menu.name}</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <#list menu.privileges as privilege>
                            <li>
                                <a onclick="xadmin.add_tab('${privilege.name}','${path}${privilege.url}')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>${privilege.name}</cite>
                                </a>
                            </li>
                        </#list>
                    </ul>
                </li>
            </#list>
        </ul>
    </div>
</div>