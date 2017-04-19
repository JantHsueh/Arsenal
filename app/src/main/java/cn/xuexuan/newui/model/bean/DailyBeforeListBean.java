package cn.xuexuan.newui.model.bean;

import java.util.List;

/**
 * Created by Jant on 2017/4/17.
 */

public class DailyBeforeListBean {

    /**
     * date : 20170415
     * stories : [{"images":["https://pic4.zhimg.com/v2-f1f981e48ff4484d2bced95910cda947.jpg"],"type":0,"id":9356469,"ga_prefix":"041522","title":"小事 · 跟我回家可好"},{"title":"故事的开始，是从后视镜里看见坐在后排的她","ga_prefix":"041521","images":["https://pic4.zhimg.com/v2-ed978b55fde698576496edf7089b76d3.jpg"],"multipic":true,"type":0,"id":9355475},{"images":["https://pic1.zhimg.com/v2-ce8de6dd3c553de6ef7925a9c9146ca0.jpg"],"type":0,"id":9360390,"ga_prefix":"041520","title":"「运筹学」看起来眼生，其实高中学代数时你就已经见过"},{"title":"在北美最高峰脚下的七天五夜，一趟终极的公路旅行","ga_prefix":"041520","images":["https://pic1.zhimg.com/v2-cd2e409f95eba6f24174a9ec8fc41dfc.jpg"],"multipic":true,"type":0,"id":9339851},{"images":["https://pic4.zhimg.com/v2-551b89436e56b148bd1fd8c7816279f7.jpg"],"type":0,"id":9360247,"ga_prefix":"041518","title":"讨论 AA 制是不是公平，不能只算饭量"},{"title":"周末去春游，当然要带上好吃的才行","ga_prefix":"041517","images":["https://pic1.zhimg.com/v2-05e96a106138f985978388537f42d840.jpg"],"multipic":true,"type":0,"id":9359892},{"images":["https://pic1.zhimg.com/v2-18e8ae6cb98d9b065e4aad53c5c5b500.jpg"],"type":0,"id":9359796,"ga_prefix":"041516","title":"微信小程序发布 100 多天，支付宝也入场了"},{"title":"同样是「随手拍」，为什么摄影师的作品那么好看？","ga_prefix":"041515","images":["https://pic4.zhimg.com/v2-9ae50e64412c7d0102fdf0ea6680a09f.jpg"],"multipic":true,"type":0,"id":9359755},{"title":"这么污的超级英雄玩具，卖给小孩真的合适吗\u2026\u2026","ga_prefix":"041514","images":["https://pic2.zhimg.com/v2-b6883375ca7494bc998b6e1890e8f2ad.jpg"],"multipic":true,"type":0,"id":9359780},{"images":["https://pic3.zhimg.com/v2-3e8841b82045721f2ae37136d13604c2.jpg"],"type":0,"id":9357194,"ga_prefix":"041513","title":"《二十四史》这样的书，应该怎么读？"},{"images":["https://pic1.zhimg.com/v2-d9921bfe3765bc74415b826055287c34.jpg"],"type":0,"id":9357118,"ga_prefix":"041512","title":"大误 · 妹子在我背上飞"},{"images":["https://pic1.zhimg.com/v2-61f31f2e1132b77981b17bc88e3ff8d0.jpg"],"type":0,"id":9350246,"ga_prefix":"041511","title":"对于航空公司而言，这是比飞机和客户都更重要的资源"},{"images":["https://pic1.zhimg.com/v2-abacb1aee39fa0e878346f0f8eea56f8.jpg"],"type":0,"id":9358136,"ga_prefix":"041510","title":"为什么你的老板雇佣了你，而不去找几个奴隶？"},{"images":["https://pic4.zhimg.com/v2-fb737a727c98b75c7c2aafec59ebe5c3.jpg"],"type":0,"id":9352393,"ga_prefix":"041509","title":"站在命运的转折点，还以为只是生命中普通的一天"},{"images":["https://pic4.zhimg.com/v2-2ad374c870be855aa7ef781d193ac033.jpg"],"type":0,"id":9358710,"ga_prefix":"041508","title":"连续减持陌陌股份，阿里是放弃社交卡位了吗？"},{"title":"没有一座海拔 5000 米以上的高峰，但这里是现代登山的发源地","ga_prefix":"041507","images":["https://pic3.zhimg.com/v2-e02e028da6649b824a9e2da637e4caea.jpg"],"multipic":true,"type":0,"id":9356590},{"images":["https://pic4.zhimg.com/v2-ae62106665f19018adfb54bc0dced16b.jpg"],"type":0,"id":9353956,"ga_prefix":"041507","title":"在封闭的环境里，男性可以通过晨勃判断是不是早晨吗？"},{"images":["https://pic1.zhimg.com/v2-14d599ef36f393f49e3df82d26276d88.jpg"],"type":0,"id":9349731,"ga_prefix":"041507","title":"丧心病狂的典范：历史上那些用了 F1 发动机的民用车"},{"images":["https://pic2.zhimg.com/v2-08523a8d66963ccb314b47be47cb8519.jpg"],"type":0,"id":9357863,"ga_prefix":"041506","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

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

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-f1f981e48ff4484d2bced95910cda947.jpg"]
         * type : 0
         * id : 9356469
         * ga_prefix : 041522
         * title : 小事 · 跟我回家可好
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
}
