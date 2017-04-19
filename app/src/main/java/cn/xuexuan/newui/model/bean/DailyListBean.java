package cn.xuexuan.newui.model.bean;

import java.util.List;

/**
 * Created by Jant on 2017/4/17.
 */

public class DailyListBean {

    /**
     * date : 20170417
     * stories : [{"images":["https://pic2.zhimg.com/v2-24ac20d5f8232b4e37824e80468ffda5.jpg"],"type":0,"id":9362966,"ga_prefix":"041715","title":"比我强的都是大神，比我弱的都是小学生"},{"images":["https://pic3.zhimg.com/v2-68f13da0e85af9326fc5c9a48d45b88a.jpg"],"type":0,"id":9363991,"ga_prefix":"041715","title":"一天 24 小时？我偏不，我就要试试一天 28 小时"},{"images":["https://pic3.zhimg.com/v2-804ec2971351a155f33e2900dd07750a.jpg"],"type":0,"id":9363091,"ga_prefix":"041713","title":"25 岁还一事无成的我看到这篇文章陷入了沉思\u2026\u2026"},{"images":["https://pic3.zhimg.com/v2-c77967453c8b649da64b07a34b97ed62.jpg"],"type":0,"id":9357131,"ga_prefix":"041712","title":"大误 · 如果把地球那么大的一团水放在太空会发生什么？"},{"images":["https://pic3.zhimg.com/v2-3fe4b331199ad8fbbe8660a5547b58fe.jpg"],"type":0,"id":9363641,"ga_prefix":"041711","title":"- 历史上有哪些著名的遗憾？\r\n- 忘记关门，国家亡了"},{"title":"汽车上的这些「救命功能」，是如何工作的？","ga_prefix":"041710","images":["https://pic3.zhimg.com/v2-2eedffbca3879da8b8b96dda538038e6.jpg"],"multipic":true,"type":0,"id":9363536},{"images":["https://pic1.zhimg.com/v2-ab41f7ad14813dd9d45d076a0490f018.jpg"],"type":0,"id":9362883,"ga_prefix":"041709","title":"打篮球受伤了谁负责？"},{"images":["https://pic1.zhimg.com/v2-d1c64c76eee56206a4c3251980d4c42c.jpg"],"type":0,"id":9361793,"ga_prefix":"041708","title":"炒一碗红亮的糖色，拒绝黑暗料理"},{"images":["https://pic3.zhimg.com/v2-077928e125952b1906cce22cef8f279e.jpg"],"type":0,"id":9362708,"ga_prefix":"041707","title":"网线里，司机老王正拉着 50 顿货物在高速公路上狂奔"},{"images":["https://pic1.zhimg.com/v2-38552992004f74598eed6e70f1c1334c.jpg"],"type":0,"id":9362900,"ga_prefix":"041707","title":"Siri 们的腔调怎么听起来那么「假」？"},{"images":["https://pic4.zhimg.com/v2-3c6653a90df3c6d798319d212afbac9f.jpg"],"type":0,"id":9362866,"ga_prefix":"041707","title":"看起来票房火爆的电影，算一算可不一定能赚钱"},{"images":["https://pic1.zhimg.com/v2-eac0a491894a17343762308b2178fe18.jpg"],"type":0,"id":9362811,"ga_prefix":"041706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-8a6e1f9937257c5fecad30c18f24d0eb.jpg","type":0,"id":9363991,"ga_prefix":"041715","title":"一天 24 小时？我偏不，我就要试试一天 28 小时"},{"image":"https://pic2.zhimg.com/v2-cb85a00d40da3250eedd09f39fb12dd5.jpg","type":0,"id":9362900,"ga_prefix":"041707","title":"Siri 们的腔调怎么听起来那么「假」？"},{"image":"https://pic1.zhimg.com/v2-92cfd405cc61b20894faccbed8e5b340.jpg","type":0,"id":9362866,"ga_prefix":"041707","title":"看起来票房火爆的电影，算一算可不一定能赚钱"},{"image":"https://pic2.zhimg.com/v2-06f72e8efbe029ab5f1834528897cfc9.jpg","type":0,"id":9360947,"ga_prefix":"041607","title":"翻了翻永安行的招股书，发现和摩拜、ofo 大不一样"},{"image":"https://pic1.zhimg.com/v2-df70c12a2f1628c144c3c750e87c4a34.jpg","type":0,"id":9360930,"ga_prefix":"041609","title":"做律师这行，一不小心就会被对方「下套」"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-24ac20d5f8232b4e37824e80468ffda5.jpg"]
         * type : 0
         * id : 9362966
         * ga_prefix : 041715
         * title : 比我强的都是大神，比我弱的都是小学生
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-8a6e1f9937257c5fecad30c18f24d0eb.jpg
         * type : 0
         * id : 9363991
         * ga_prefix : 041715
         * title : 一天 24 小时？我偏不，我就要试试一天 28 小时
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
