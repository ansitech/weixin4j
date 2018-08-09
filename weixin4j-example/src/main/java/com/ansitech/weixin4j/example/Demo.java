package com.ansitech.weixin4j.example;

import java.util.ArrayList;
import java.util.List;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.component.MenuComponent;
import org.weixin4j.model.menu.ClickButton;
import org.weixin4j.model.menu.MiniprogramButton;
import org.weixin4j.model.menu.SingleButton;
import org.weixin4j.model.menu.ViewButton;

/**
 * 开始开发，weixin4j使用入门
 *
 * 本示例介绍了weixin4j开发中的入口，对于独立项目中仅用来做一些快速上手的接口
 *
 * 进行调用，快速入门使用，对于需要微信网页开发请大家参考weixin4j-web-demo
 *
 * @author 杨启盛<qsyang@ansitech.com>
 */
public class Demo {

    /**
     * 本示例直接采用main方法运行，做到开箱即用
     *
     * Weixin对象为调用入口，里面包含了几乎常用的接口，并以组件的方式展示，
     *
     * 本示例展示了自定义菜单的创建，以供初学者参考
     *
     * @param args
     */
    public static void main(String[] args) {
        //系统会直接从weixin4j.properties中读取配置
        //weixin4j.properties可以放在classes下，即项目的src目录下
        //对于maven项目，则放在resources目录下
        //但是优先以系统设置的属性为准，例如：
        System.setProperty("weixin4j.debug", "false");
        //打印调试开关，如果打开调试开关，则会向控制台打印方法调用执行日志
        System.out.println(Configuration.isDebug());
        //1.初始化weixin对象
        Weixin weixin = new Weixin();
        //2.打印开发者appid
        System.out.println(weixin.getAppId());
        //3.下面为大家演示利用菜单组件来创建公众号自定义菜单
        //组件命名以微信的接口api请求为名
        //例如自定义菜单接口请求地址
        //  https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
        //则是menu/create，则我们取menu为组件名，其他组件以此类推
        //3.1获取菜单组件
        MenuComponent menuComponet = weixin.menu();
        //调用组件创建方法
        //menuComponet.create(menu);
        //组件创建需要一个Menu对象，我们也可以看到这个对象在org.weixin4j.model目录下
        //model目录下是我们所有开发中用到的对象，也是以组件分的包名
        //例如自定义菜单组件，就是menu，所有相关对象则=在org.weixin4j.model.menu下
        org.weixin4j.model.menu.Menu menu = new org.weixin4j.model.menu.Menu();
        //关于menu对象，有2个构造函数，一个带参，一个不带参
        //带参的构造函数是一个json对象，需要的格式为{menu:{...}}
        //这个menu是必须包含的对象，对象内是一个按钮对象集合，以官方网站示例为例：
        //{
        //     "button":[
        //     {    
        //          "type":"click",
        //          "name":"今日歌曲",
        //          "key":"V1001_TODAY_MUSIC"
        //      },
        //      {
        //           "name":"菜单",
        //           "sub_button":[
        //           {    
        //               "type":"view",
        //               "name":"搜索",
        //               "url":"http://www.soso.com/"
        //            },
        //            {
        //                 "type":"miniprogram",
        //                 "name":"wxa",
        //                 "url":"http://mp.weixin.qq.com",
        //                 "appid":"wx286b93c14bbf93aa",
        //                 "pagepath":"pages/lunar/index"
        //             },
        //            {
        //               "type":"click",
        //               "name":"赞一下我们",
        //               "key":"V1001_GOOD"
        //            }]
        //       }]
        // }
        //下面是json创建自定义菜单的案例
        //String json = "{\"menu\":\" {"
        //        + "     \"button\":["
        //        + "     {    "
        //        + "          \"type\":\"click\","
        //        + "          \"name\":\"今日歌曲\","
        //        + "          \"key\":\"V1001_TODAY_MUSIC\""
        //        + "      },"
        //        + "      {"
        //        + "           \"name\":\"菜单\","
        //        + "           \"sub_button\":["
        //        + "           {    "
        //        + "               \"type\":\"view\","
        //        + "               \"name\":\"搜索\","
        //        + "               \"url\":\"http://www.soso.com/\""
        //        + "            },"
        //        + "            {"
        //        + "                 \"type\":\"miniprogram\","
        //        + "                 \"name\":\"wxa\","
        //        + "                 \"url\":\"http://mp.weixin.qq.com\","
        //        + "                 \"appid\":\"wx286b93c14bbf93aa\","
        //        + "                 \"pagepath\":\"pages/lunar/index\""
        //        + "             },"
        //        + "            {"
        //        + "               \"type\":\"click\","
        //        + "               \"name\":\"赞一下我们\","
        //        + "               \"key\":\"V1001_GOOD\""
        //        + "            }]"
        //        + "       }]"
        //        + " }\"}";
        //org.weixin4j.model.menu.Menu menu = new org.weixin4j.model.menu.Menu(json);
        //接下面我们演示用对象的方式创建自定义菜单
        List<SingleButton> buttons = new ArrayList<SingleButton>();

        //创建菜单1 click button
        ClickButton button1 = new ClickButton("今日歌曲", "V1001_TODAY_MUSIC");
        //添加一级菜单1
        buttons.add(button1);

        //创建菜单2 可以包含二级子菜单
        SingleButton button2 = new SingleButton("菜单");

        //创建2级子菜单1，打开页面
        ViewButton button2_1 = new ViewButton("搜索", "http://www.soso.com/");
        button2.getSubButton().add(button2_1);

        //创建2级子菜单2，打开小程序
        MiniprogramButton button2_2 = new MiniprogramButton("wxa");
        button2_2.setAppid("wx286b93c14bbf93aa");
        button2_2.setPagepath("pages/lunar/index");
        button2_2.setUrl("http://mp.weixin.qq.com");
        button2.getSubButton().add(button2_2);

        //创建2级子菜单3，点击事件
        ClickButton button2_3 = new ClickButton("赞一下我们", "V1001_GOOD");
        button2.getSubButton().add(button2_3);

        //添加一级菜单2
        buttons.add(button2);

        //设置自定义菜单
        menu.setButton(buttons);

        try {
            //调用微信自定义菜单组件，创建自定义菜单
            menuComponet.create(menu);
        } catch (WeixinException ex) {
            //打印创建异常日志
            ex.printStackTrace();
        }
    }
}
