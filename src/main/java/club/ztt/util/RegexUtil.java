package club.ztt.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 赵涛涛
 * @date 2017/11/12.
 */
public class RegexUtil {
    // 定义script的正则表达式
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    // 定义style的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    // 定义HTML标签的正则表达式
    private static final String regEx_html = "<[^>]+>";
    // 定义空格回车换行符
    private static final String regEx_space = "\\s*|\t|\r|\n";
    //定义所有w标签
    private static final String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";

    /**
     * @param htmlStr
     * @return 删除Html标签
     * @author LongJin
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_w = Pattern.compile(regEx_w, Pattern.CASE_INSENSITIVE);
        Matcher m_w = p_w.matcher(htmlStr);
        htmlStr = m_w.replaceAll(""); // 过滤script标签


        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签


        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签


        htmlStr = htmlStr.replaceAll(" ", ""); //过滤
        return htmlStr.trim(); // 返回文本字符串
    }

    @Test
    public void test(){
        String str = "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"zh-cn\">\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "<title>java空指针异常：java.lang.NullPointException - kkernel - 博客园</title>\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/bundles/blog-common.css?v=ChDk9h03-S75WEqNhGvXkWireJ5cCWdK1xRM9NIXfnM1\"/>\n" +
                "<link id=\"MainCss\" type=\"text/css\" rel=\"stylesheet\" href=\"/skins/WebLoad/bundle-WebLoad.css?v=iiJH4irBCKZqoEfwbCT0ZOeuhQwYOdDB4yxQZEgWLJs1\"/>\n" +
                "<link id=\"mobile-style\" media=\"only screen and (max-width: 767px)\" type=\"text/css\" rel=\"stylesheet\" href=\"/skins/WebLoad/bundle-WebLoad-mobile.css?v=d9LctKHRIQp9rreugMcQ1-UJuq_j1fo0GZXTXj8Bqrk1\"/>\n" +
                "<link title=\"RSS\" type=\"application/rss+xml\" rel=\"alternate\" href=\"http://www.cnblogs.com/ttflove/rss\"/>\n" +
                "<link title=\"RSD\" type=\"application/rsd+xml\" rel=\"EditURI\" href=\"http://www.cnblogs.com/ttflove/rsd.xml\"/>\n" +
                "<link type=\"application/wlwmanifest+xml\" rel=\"wlwmanifest\" href=\"http://www.cnblogs.com/ttflove/wlwmanifest.xml\"/>\n" +
                "<script src=\"//common.cnblogs.com/script/jquery.js\" type=\"text/javascript\"></script>  \n" +
                "<script type=\"text/javascript\">var currentBlogApp = 'ttflove', cb_enable_mathjax=false;var isLogined=true;</script>\n" +
                "<script src=\"/bundles/blog-common.js?v=DRleNSOp-2-RdlbwNt69QQ4yKTISMA1DSih-VNOSd9w1\" type=\"text/javascript\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a name=\"top\"></a>\n" +
                "\n" +
                "<div id=\"home\">\n" +
                "<div id=\"header\">\n" +
                "\t<div id=\"blogTitle\">\n" +
                "\t\t\n" +
                "<!--done-->\n" +
                "<div class=\"title\"><a id=\"Header1_HeaderTitle\" class=\"headermaintitle\" href=\"http://www.cnblogs.com/ttflove/\">kkernel</a></div>\n" +
                "<div class=\"subtitle\">Be a man in the summit.</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\t</div><!--end: blogTitle 博客的标题和副标题 -->\n" +
                "\t<div id=\"navigator\">\n" +
                "\t\t\n" +
                "<ul id=\"navList\">\n" +
                "<li id=\"nav_sitehome\"><a id=\"blog_nav_sitehome\" class=\"menu\" href=\"http://www.cnblogs.com/\">博客园</a></li>\n" +
                "<li id=\"nav_myhome\"><a id=\"blog_nav_myhome\" class=\"menu\" href=\"http://www.cnblogs.com/ttflove/\">首页</a></li>\n" +
                "<li id=\"nav_newpost\"><a id=\"blog_nav_newpost\" class=\"menu\" rel=\"nofollow\" href=\"https://i.cnblogs.com/EditPosts.aspx?opt=1\">新随笔</a></li>\n" +
                "<li id=\"nav_contact\"><a id=\"blog_nav_contact\" class=\"menu\" rel=\"nofollow\" href=\"https://msg.cnblogs.com/send/kkernel\">联系</a></li>\n" +
                "<li id=\"nav_rss\"><a id=\"blog_nav_rss\" class=\"menu\" href=\"http://www.cnblogs.com/ttflove/rss\">订阅</a>\n" +
                "<!--<a id=\"blog_nav_rss_image\" class=\"aHeaderXML\" href=\"http://www.cnblogs.com/ttflove/rss\"><img src=\"//www.cnblogs.com/images/xml.gif\" alt=\"订阅\" /></a>--></li>\n" +
                "<li id=\"nav_admin\"><a id=\"blog_nav_admin\" class=\"menu\" rel=\"nofollow\" href=\"https://i.cnblogs.com/\">管理</a></li>\n" +
                "</ul>\n" +
                "\n" +
                "\t\t<div class=\"blogStats\">\n" +
                "\t\t\t\n" +
                "\t\t\t<div id=\"blog_stats\">\n" +
                "<!--done-->\n" +
                "随笔-13&nbsp;\n" +
                "文章-3&nbsp;\n" +
                "评论-5&nbsp;\n" +
                "</div>\n" +
                "\t\t\t\n" +
                "\t\t</div><!--end: blogStats -->\n" +
                "\t</div><!--end: navigator 博客导航栏 -->\n" +
                "</div><!--end: header 头部 -->\n" +
                "<div id=\"main\">\n" +
                "\t<div id=\"mainContent\">\n" +
                "\t<div class=\"forFlow\">\n" +
                "\t\t\n" +
                "<div id=\"post_detail\">\n" +
                "<!--done-->\n" +
                "<div id=\"topics\">\n" +
                "\t<div class = \"post\">\n" +
                "\t\t<h1 class = \"postTitle\">\n" +
                "\t\t\t<a id=\"cb_post_title_url\" class=\"postTitle2\" href=\"http://www.cnblogs.com/ttflove/p/6033393.html\">java空指针异常：java.lang.NullPointException</a>\n" +
                "\t\t</h1>\n" +
                "\t\t<div class=\"clear\"></div>\n" +
                "\t\t<div class=\"postBody\">\n" +
                "\t\t\t<div id=\"cnblogs_post_body\"><p>一.什么是java空指针异常</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; 我们都知道java是没有指针的，这里说的\"java指针\"指的就是java的引用,我们不在这里讨论叫指针究竟合不合适，而只是针对这个异常本身进行分析。空指针就是空引用，java空指针异常就是引用本身为空，却调用了方法，这个时候就会出现空指针异常。可以理解，成员变量和方法是属于对象的（除去静态），在对象中才存在相对应的成员变量和方法，然后通过对象去调用这些成员变量和方法。对于空指针来说，它不指向任何对象，也就没有所谓的成员变量和方法，这个时候用它去调用某些属性和方法，当然会出现空指针异常。</p>\n" +
                "<div class=\"cnblogs_code\">\n" +
                "<pre><span style=\"color: #008080\"> 1</span> <span style=\"color: #0000ff\">public</span> <span style=\"color: #0000ff\">class</span><span style=\"color: #000000\"> Test {\n" +
                "</span><span style=\"color: #008080\"> 2</span>     <span style=\"color: #0000ff\">private</span> <span style=\"color: #0000ff\">int</span> a=1<span style=\"color: #000000\">;\n" +
                "</span><span style=\"color: #008080\"> 3</span>     <span style=\"color: #0000ff\">private</span> <span style=\"color: #0000ff\">int</span> b=2<span style=\"color: #000000\">;\n" +
                "</span><span style=\"color: #008080\"> 4</span>     <span style=\"color: #0000ff\">public</span> <span style=\"color: #0000ff\">static</span> <span style=\"color: #0000ff\">void</span><span style=\"color: #000000\"> main(String[] args) {\n" +
                "</span><span style=\"color: #008080\"> 5</span>         <span style=\"color: #008000\">//</span><span style=\"color: #008000\"> TODO Auto-generated method stub</span>\n" +
                "<span style=\"color: #008080\"> 6</span>         Test t1 = <span style=\"color: #0000ff\">new</span><span style=\"color: #000000\"> Test();\n" +
                "</span><span style=\"color: #008080\"> 7</span>         Test t2 = <span style=\"color: #0000ff\">null</span><span style=\"color: #000000\">;\n" +
                "</span><span style=\"color: #008080\"> 8</span> <span style=\"color: #000000\">        System.out.println(t1.a);\n" +
                "</span><span style=\"color: #008080\"> 9</span> <span style=\"color: #000000\">        System.out.println(t2.a);\n" +
                "</span><span style=\"color: #008080\">10</span> <span style=\"color: #000000\">        System.out.println(t2.c());\n" +
                "</span><span style=\"color: #008080\">11</span> <span style=\"color: #000000\">    }\n" +
                "</span><span style=\"color: #008080\">12</span>     <span style=\"color: #0000ff\">public</span><span style=\"color: #000000\"> String c(){\n" +
                "</span><span style=\"color: #008080\">13</span>         <span style=\"color: #0000ff\">return</span> \"123\"<span style=\"color: #000000\">;\n" +
                "</span><span style=\"color: #008080\">14</span> <span style=\"color: #000000\">    }\n" +
                "</span><span style=\"color: #008080\">15</span> }</pre>\n" +
                "</div>\n" +
                "<p>我们分析上面这段示例代码，在Test类中，有两个成员变量a和b，和一个方法c()。然后在main()方法中，我们创建了两个对象t1和t2，其中t1指向通过构造方法实例出的Test对象，而t2只是声明，并指向了空，并没有指向实际的对象。调试的时候，第一条输出语句是可以通过编译的，而执行到第二条输出语句的时候，由于空指针调用了不属于它的a，程序终止，报告空指针异常。同样，注释第二条输出语句，程序在执行到第三条输出语句的时候，由于调用了不属于它的c()方法，会出现一样的错误。</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>二.如何解决</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; 对于每一个java程序员来说，几乎都避免不了遇到空指针异常，特别是经验不足的初学者。而且由于它的调试和查找相对其它异常来说比较困难，常常需要花费很大的精力去解决它。</p>\n" +
                "<p>&nbsp; &nbsp; <strong>首先认识一下java中的null</strong></p>\n" +
                "<p><strong>&nbsp;&nbsp;&nbsp; </strong>null是Java中一个很重要的概念。null设计初衷是为了表示一些缺失的东西，例如缺失的用户、资源或其他东西。但是，一年后，令人头疼的空指针异常给Java程序员带来不少的骚扰。</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; null是java中的关键字，因此，它不能写成NULL，Null，只能是null。</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; null是所有引用类型的默认值，如果没有让一个引用指向一个实际存在的对象，它的默认值就是null。null本质上是一个值，这跟int的默认值是0，boolean的默认值是false一样。现在，我们通常都使用像eclipse等的集成开发环境进行开发，一般在定义变量的时候都会进行初始化（这也是写代码的一个良好的习惯），如果没有进行初始化，系统会进行提示。</p>\n" +
                "<p><strong>报空指针异常的原因有以下几种：</strong>&nbsp;</p>\n" +
                "<p>1字符串变量未初始化；&nbsp;<br>2接口类型的对象没有用具体的类初始化，比如：&nbsp;<br>List it；会报错&nbsp;<br>List it = new ArrayList()；则不会报错了&nbsp;<br>3当一个对象的值为空时，你没有判断为空的情况。你可以试着把下面的代码前加一行代码：&nbsp;<br>if(rb!=null &amp;&amp; rb!=\"\")&nbsp;<br>改成：&nbsp;<br>if(rb==null);&nbsp;<br>if(rb!==null&amp;&amp;rb!=\"\") 或者if(\"\").equals(rb))&nbsp;<br>空指针的解决办法：&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 重点关注报错发生的所在行，通过空指针异常产生的两条主要原因诊断具体的错误。同时为了避免空指针的发生，最好在做判断处理时将“null”或者空值放于 设定的值之前。&nbsp;<br>常见空指针异常的简要分析：&nbsp;<br>（1）空指针错误&nbsp;<br>&nbsp;&nbsp;&nbsp; Java中的8种基本数据类型，变量的值可以有其默认值，加入没有对其正常赋值，java虚拟机是不能 正确编译通过的，因此使用基本的Java数据类型一般是不会引起空指针异常的。实际开发中，大多数的空指针异常主要与对象的操作相关。 <br>&nbsp;&nbsp;&nbsp; 下面列出可能发生空指针异常的几种情况及相应解决方案：&nbsp;<br>&nbsp;&nbsp;&nbsp; 代码段1：&nbsp;<br>　　out.println(request.getParameter(\"username\"));&nbsp;<br>　　分析：代码段1的功能十分简单，就是输出用户输入\"username\"的值。&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说明：看上去，上面的语句找不出什么语法错误，而且在大多数情况下也遇不到什么问题。但是，如果某个用户在输入数据时并没有提供表单 域\"username\" 的值，或通过某种途径绕过表单直接输入时，此request.getParameter(\"username\")的值为空（注意不是空字符串，是空对象 null。），out对象的println方法是无法直接对空对象操作的，因此代码段1所在的JSP页面将会抛出 \"Java.lang.NullPointerException\"异常。而且即使对象可能为空时，也调用Java.lang.Object或 Object对象本身的一些方法如toString()， equal(Object obj)等操作。 <br>&nbsp;&nbsp;&nbsp; 代码段2：&nbsp;<br>　　String userName = request.getParameter(\"username\");&nbsp;<br>　　If (userName.equals(\"root\"))&nbsp;<br>　　{....}&nbsp;<br>　　分析：代码段2的功能是检测用户提供的用户名，如果是用户名称为\"root\"的用户时，就执行一些特别的操作。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说明：在代码段2中，如果有用户没有提供表单域\"username\"的值时，字符串对象userName为null值，不能够将一个null的对象与另一 个对象直接比较，同样，代码段2所在的JSP页面就会抛空指针错误。 <br>&nbsp;&nbsp;&nbsp;&nbsp; 一个小技巧：如果要把某个方法的返回值与常量做比较，把常量放在前面，可以避免调用null对象的equals方法。譬如：&nbsp; <br>&nbsp;&nbsp;&nbsp; If (\"root\".equals(userName))&nbsp;<br>　 {....} <br>&nbsp;&nbsp;&nbsp; 即使userName对象返回了null对象，这里也不会有空指针异常，可以照常运转。 <br>&nbsp;&nbsp;&nbsp; 代码段3：&nbsp;<br>　　String userName = session.getAttribute(\"session.username\").toString();&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 分析：代码段3的功能是将session中session.username的值取出，并将该值赋给字符串对象userName。&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说明：在一般情况下，如果在用户已经进行某个会话，则不会出现什么问题；但是，如果此时应用服务器重新启动，而用户还没有重新登录，（也可能是用户关闭浏 览器，但是仍打开原来的页面。）那么，此时该session的值就会失效，同时导致session中的session.username的值为空。对一个 为 null的对象的直接执行toString()操作，就会导致系统抛出空指针异常。 <br>&nbsp;&nbsp;&nbsp; 代码段4：&nbsp;<br>public static void main(String args[]){ <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Person p=null; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; p.setName(\"张三\")； <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; System.out.println(p.getName()); <br>} <br>分析：声明一个Person对象，并打印出该对象的中的Name名字。 <br>说明：这个时候你的p就出现空指针异常，因为你只是声明了这个Person类型的对象并没有创建对象，所以它的堆里面没有地址引用，切忌你要用对 象掉用方法的时候一定要创建对象。</p>\n" +
                "<div id=\"digg\">&nbsp;</div>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; </p>\n" +
                "<p>&nbsp;</p></div><div id=\"MySignature\"></div>\n" +
                "<div class=\"clear\"></div>\n" +
                "<div id=\"blog_post_info_block\">\n" +
                "<div id=\"BlogPostCategory\"></div>\n" +
                "<div id=\"EntryTag\"></div>\n" +
                "<div id=\"blog_post_info\">\n" +
                "</div>\n" +
                "<div class=\"clear\"></div>\n" +
                "<div id=\"post_next_prev\"></div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\t\t</div>\n" +
                "\t\t<div class = \"postDesc\">posted @ <span id=\"post-date\">2016-11-19 20:36</span> <a href='http://www.cnblogs.com/ttflove/'>kkernel</a> 阅读(<span id=\"post_view_count\">...</span>) 评论(<span id=\"post_comment_count\">...</span>)  <a href =\"https://i.cnblogs.com/EditPosts.aspx?postid=6033393\" rel=\"nofollow\">编辑</a> <a href=\"#\" onclick=\"AddToWz(6033393);return false;\">收藏</a></div>\n" +
                "\t</div>\n" +
                "\t<script type=\"text/javascript\">var allowComments=true,cb_blogId=310559,cb_entryId=6033393,cb_blogApp=currentBlogApp,cb_blogUserGuid='e7d9340c-977a-e611-9fc1-ac853d9f53cc',cb_entryCreatedDate='2016/11/19 20:36:00';loadViewCount(cb_entryId);var cb_postType=1;</script>\n" +
                "\t\n" +
                "</div><!--end: topics 文章、评论容器-->\n" +
                "</div><a name=\"!comments\"></a><div id=\"blog-comments-placeholder\"></div><script type=\"text/javascript\">var commentManager = new blogCommentManager();commentManager.renderComments(0);</script>\n" +
                "<div id='comment_form' class='commentform'>\n" +
                "<a name='commentform'></a>\n" +
                "<div id='divCommentShow'></div>\n" +
                "<div id='comment_nav'><span id='span_refresh_tips'></span><a href='javascript:void(0);' onclick='return RefreshCommentList();' id='lnk_RefreshComments' runat='server' clientidmode='Static'>刷新评论</a><a href='#' onclick='return RefreshPage();'>刷新页面</a><a href='#top'>返回顶部</a></div>\n" +
                "<div id='comment_form_container'></div>\n" +
                "<div class='ad_text_commentbox' id='ad_text_under_commentbox'></div>\n" +
                "<div id='ad_t2'></div>\n" +
                "<div id='opt_under_post'></div>\n" +
                "<div id='cnblogs_c1' class='c_ad_block'></div>\n" +
                "<div id='under_post_news'></div>\n" +
                "<div id='cnblogs_c2' class='c_ad_block'></div>\n" +
                "<div id='under_post_kb'></div>\n" +
                "<div id='HistoryToday' class='c_ad_block'></div>\n" +
                "<script type='text/javascript'>\n" +
                "    fixPostBody();\n" +
                "    setTimeout(function () { incrementViewCount(cb_entryId); }, 50);\n" +
                "    deliverAdT2();\n" +
                "    deliverAdC1();\n" +
                "    deliverAdC2();    \n" +
                "    loadNewsAndKb();\n" +
                "    loadBlogSignature();\n" +
                "    LoadPostInfoBlock(cb_blogId, cb_entryId, cb_blogApp, cb_blogUserGuid);\n" +
                "    GetPrevNextPost(cb_entryId, cb_blogId, cb_entryCreatedDate, cb_postType);\n" +
                "    loadOptUnderPost();\n" +
                "    GetHistoryToday(cb_blogId, cb_blogApp, cb_entryCreatedDate);   \n" +
                "</script>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\t</div><!--end: forFlow -->\n" +
                "\t</div><!--end: mainContent 主体内容容器-->\n" +
                "\n" +
                "\t<div id=\"sideBar\">\n" +
                "\t\t<div id=\"sideBarMain\">\n" +
                "\t\t\t\n" +
                "<!--done-->\n" +
                "<div class=\"newsItem\">\n" +
                "<h3 class=\"catListTitle\">公告</h3>\n" +
                "\t<div id=\"blog-news\"></div><script type=\"text/javascript\">loadBlogNews();</script>\n" +
                "</div>\n" +
                "\n" +
                "\t\t\t<div id=\"calendar\"><div id=\"blog-calendar\" style=\"display:none\"></div><script type=\"text/javascript\">loadBlogDefaultCalendar();</script></div>\n" +
                "\t\t\t\n" +
                "\t\t\t<div id=\"leftcontentcontainer\">\n" +
                "\t\t\t\t<div id=\"blog-sidecolumn\"></div><script type=\"text/javascript\">loadBlogSideColumn();</script>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t</div><!--end: sideBarMain -->\n" +
                "\t</div><!--end: sideBar 侧边栏容器 -->\n" +
                "\t<div class=\"clear\"></div>\n" +
                "\t</div><!--end: main -->\n" +
                "\t<div class=\"clear\"></div>\n" +
                "\t<div id=\"footer\">\n" +
                "\t\t\n" +
                "<!--done-->\n" +
                "Copyright &copy;2017 kkernel\n" +
                "\t</div><!--end: footer -->\n" +
                "</div><!--end: home 自定义的最大容器 -->\n" +
                "</body>\n" +
                "</html>\n";
        String str2 = RegexUtil.delHTMLTag(str);
        System.out.println(str2);
    }
}
