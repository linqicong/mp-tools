package com.boal.wechat.api;

import com.boal.wechat.model.Menu;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.menu.MenuGetResponse;

import java.util.List;

/**
 * 菜单api
 * 暂时未包括个性化菜单
 */
public interface MenuApi {
    /**
     * 创建菜单
     * @param menuList
     * @return
     */
    public NoParamResponse createMenu(List<Menu> menuList);

    /**
     * 获取菜单
     * @return
     */
    public MenuGetResponse getMenus();

    /**
     * 删除菜单
     * @return
     */
    public NoParamResponse delMenus();
}
