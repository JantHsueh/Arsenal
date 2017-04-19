package cn.xuexuan.newui.model.bean;

import java.util.List;

/**
 * Created by Jant on 2017/4/17.
 */

public class ZhiHuDetailBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title">吃饭 AA 公平吗？如一方的饭量是另一方的两到三倍，这样对另一方来说不吃亏吗？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/da8e974dc_is.jpg">
     <span class="author">知乎用户</span>
     </div>

     <div class="content">
     <p>大家的讨论非常有趣，我也凑个热闹回答一下。</p>
     <p>现有的诸多答案中，有一个问题大家没有涉及到，那就是：</p>
     <p>我们为什么觉得一顿饭好吃？</p>
     <p>经常出去吃饭的朋友应该都有这种感觉：一顿饭好不好吃，最关键的不在于<strong>菜的分量多少</strong>，而在于<strong>菜的种类多少</strong>。</p>
     <p>举例说吧，在外面吃饭，多数时候桌子上点的菜都是不同的。假设 5 个人一起出去点菜，即使他们的口味再相近，也绝不会把同样的一盘菜点上 5 份，除非是去吃牛肉面、盖浇饭。如果人只在乎菜的分量的话，点什么菜应该没有关系才对，只要吃饱肚子就一样开心，不是吗？</p>
     <p>可是，我们之所以点不同的菜，是因为人喜欢同时有多种选择，喜欢荤素搭配，每种菜吃一点，这样即使我们吃掉的总量相同，吃饭的感受也会比只有一道菜更好。就连盒饭也会讲究&rdquo;三菜一汤&ldquo;，正是这个道理。</p>
     <p>在经济学中，这种习惯被称为 love of variety preferences（多样性偏好）。特点是，消费的总量一定的情况下，种类越多越开心。</p>
     <p>举个最简单的例子，一个符合多样性偏好的的效用函数是这样的：<img src="http://www.zhihu.com/equation?tex=U+%3D+%5Csum_%7Bi%3D1%7D%5EN+%5Csqrt%7Bq_i%7D" alt="U = \sum_{i=1}^N \sqrt{q_i}" /></p>
     <p><img src="http://www.zhihu.com/equation?tex=i+%3D+1...N" alt="i = 1...N" /> 是菜的编号， <img src="http://www.zhihu.com/equation?tex=q_i" alt="q_i" /> 表示你吃掉的第<img src="http://www.zhihu.com/equation?tex=i" alt="i" />道菜的分量（克），<img src="http://www.zhihu.com/equation?tex=U" alt="U" /> 表示你的效用。</p>
     <p>假设你总共的饭量是 100 克，也就是说吃掉的所有的菜的分量加起来要小于 100 克：<img src="http://www.zhihu.com/equation?tex=%5Csum_%7Bi%3D1%7D%5EN+q_i+%5Cle+100" alt="\sum_{i=1}^N q_i \le 100" />。那么当饭菜种类<img src="http://www.zhihu.com/equation?tex=N" alt="N" /> 越多时，你可以达到的效用水平也就越高：</p>
     <ul>
     <li>点一道菜，每道菜吃 100 克：<img src="http://www.zhihu.com/equation?tex=U_1+%3D+%5Csqrt%7B100%7D+%3D+10" alt="U_1 = \sqrt{100} = 10" /></li>
     <li>点两道菜，每道菜吃 50 克：<img src="http://www.zhihu.com/equation?tex=U_2+%3D+%5Csqrt%7B50%7D%2B%5Csqrt%7B50%7D+%5Capprox+14.14" alt="U_2 = \sqrt{50}+\sqrt{50} \approx 14.14" /></li>
     <li>点三道菜，每道菜吃 33.33 克：<img src="http://www.zhihu.com/equation?tex=U_3+%3D+3+%5Ctimes+%5Csqrt%7B%5Cfrac%7B100%7D%7B3%7D%7D+%5Capprox+17.32+" alt="U_3 = 3 \times \sqrt{\frac{100}{3}} \approx 17.32 " /></li>
     <li>....</li>
     <li>点十道菜，每道菜吃 10 克：<img src="http://www.zhihu.com/equation?tex=U_%7B10%7D+%3D+10%5Ctimes%5Csqrt%7B10%7D%5Capprox+31.62" alt="U_{10} = 10\times\sqrt{10}\approx 31.62" /></li>
     <li>...</li>
     <li>点一百道菜，每道菜吃 1 克（慈禧老佛爷）：<img src="http://www.zhihu.com/equation?tex=U_%7B100%7D+%3D+100%5Ctimes+%5Csqrt%7B1%7D+%3D100" alt="U_{100} = 100\times \sqrt{1} =100" /></li>
     </ul>
     <p>就不再往多了算了，大家应该懂我的意思了。</p>
     <p>所以说，我们吃饭的时候，最大的限制往往不是钱包，而是我们的饭量。再有钱的人也不可能有两个胃，<strong>所以从每个人的角度说，多吃几种菜，每种菜少吃一些，往往比吃一种菜吃到饱要更爽。</strong></p>
     <p><strong>这样，当两个人一起吃饭时，即使你的饭量只有对方的二分之一，不代表这顿饭就亏了</strong>。毕竟，和你自己单独吃相比，虽然你吃的量减少了，但是品种多了呀！</p>
     <p>用上面的效用函数举例子，假设你们点了两个菜，每道 100 克。你的饭量是对方的二分之一，每道只吃了 33.33 克。你的效用是：<img src="http://www.zhihu.com/equation?tex=U+%3D+%5Csqrt%7B%5Cfrac%7B100%7D%7B3%7D%7D+%5Ctimes+2+%5Capprox+11.54" alt="U = \sqrt{\frac{100}{3}} \times 2 \approx 11.54" /></p>
     <p>还是比自己一个人点一个菜的时候，<img src="http://www.zhihu.com/equation?tex=U+%3D+%5Csqrt%7B100%7D+%3D+10" alt="U = \sqrt{100} = 10" /> 要开心的。</p>
     <p>当然，这个也要有限度&mdash;&mdash;假如你的饭量是对方的 99 分之一，你每道菜只吃了一克，你当然不爽了：你的效用只有&nbsp;<img src="http://www.zhihu.com/equation?tex=U+%3D+%5Csqrt%7B1%7D%5Ctimes+2+%3D+2" alt="U = \sqrt{1}\times 2 = 2" />，好可怜。</p>
     <p>最后想谈谈题目所说的『公平』。其实，一件事是否公平是一个非常主观的问题。同样多的菜，对于不同的人来说，吃下肚子带给他们的开心程度也是不同的，更何况菜与菜之间的差距就像人与人之间的差距那么大。所以，与其和别人比较谁吃的多，谁吃的少，怎样最公平，不如只是放平心态问问自己这个问题：</p>
     <p><strong>和自己一个人吃饭相比，和他 / 她在一起吃饭，是不是更开心了呢？</strong></p>
     <p>毕竟，没人陪伴的时候觉得孤单寂寞，有人陪伴了却还想要追求什么公平，这不是自己找不开心吗？</p>
     <p>你问我和你一起吃饭值不值得。&nbsp;</p>
     <blockquote>其实你应该知道，爱就是不问值得不值得。<br /><br />-- 张爱玲</blockquote>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/58043628">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : Yestone.com 版权图片库
     * title : 讨论 AA 制是不是公平，不能只算饭量
     * image : https://pic4.zhimg.com/v2-f8889d713b31525752f7c5a77b4eceeb.jpg
     * share_url : http://daily.zhihu.com/story/9360247
     * js : []
     * ga_prefix : 041518
     * images : ["https://pic4.zhimg.com/v2-551b89436e56b148bd1fd8c7816279f7.jpg"]
     * type : 0
     * id : 9360247
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
