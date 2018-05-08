package com.huangasys.recycleGridMultiItemDemo;

import java.util.List;

/**
 * Created by huangasys on 2018/5/8.11:06
 *
 * @Describe:
 */

public class SiteBean {

    /**
     * sites : [{"name":"Gratisography","url":"http://www.gratisography.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.gratisography.com.ico"},{"name":"Unsplash","url":"http://unsplash.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/unsplash.com.ico"},{"name":"Publicdomainarchive","url":"http://publicdomainarchive.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/publicdomainarchive.com.ico"},{"name":"pixabay","url":"http://pixabay.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/pixabay.com.ico"},{"name":"pexels","url":"http://www.pexels.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.pexels.com.ico"},{"name":"peakpx","url":"http://www.peakpx.com","avatar_url":"https://favicon.b0.upaiyun.com/ip2/www.peakpx.com.ico"},{"name":"pixite source","url":"http://source.pixite.co","avatar_url":"https://favicon.b0.upaiyun.com/ip2/source.pixite.co.ico"},{"name":"泼辣有图","url":"http://www.polayoutu.com/collections","avatar_url":"https://diycode.b0.upaiyun.com/site/2017/703bb38696fa400114f3f5802362bef9.png"},{"name":"visualhunt","url":"http://visualhunt.com","avatar_url":"https://diycode.b0.upaiyun.com/site/2017/8d723702fa1d85c94f8e61e066646dbc.png"}]
     * name : Free high-resolution pictures WebSites － 免费高清无版权图片素材网站
     * id : 21
     */

    private String name;
    private int id;
    private List<SitesBean> sites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SitesBean> getSites() {
        return sites;
    }

    public void setSites(List<SitesBean> sites) {
        this.sites = sites;
    }

    public static class SitesBean {
        /**
         * name : Gratisography
         * url : http://www.gratisography.com
         * avatar_url : https://favicon.b0.upaiyun.com/ip2/www.gratisography.com.ico
         */

        private String name;
        private String url;
        private String avatar_url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }
}
