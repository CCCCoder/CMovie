##### 父级展示页面
* 头部增加搜索功能用于搜索相关电影
> 搜索接口(需要分页) GET：
> https://ticket-api-m.mtime.cn/search/multiSearch.api?keyword=你好陌生人&locationId=295&pageIndex=1&searchType=3
> keyword：搜索关键词
> locationid：当前城市id
> pageindex：当前页数
> searchtype：搜索类型（电影：3，演员：2）

* 展示各类汇总榜单列表
> 榜单接口(需要分页) GET：
> https://content-api-m.mtime.cn/movieList/channel/list.api?channelId=4&pageIndex=1&pageSize=30
> 
>pageIndex：当前页数
>pageSize：当前页的个数
>channelId：汇总类型（小编强推：1，明星力荐：2，追剧向导：3，时光热榜：4）----- 一般来讲，此功能是做四个tab来实现，根据自己需要来做。