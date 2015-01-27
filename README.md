# PullToRefreshLibrary
支持瀑布流的下拉刷新和滑到底部加载更多
=
实现原理：基于com.handmark.pulltorefresh和com.etsy.android.grid.StaggeredGridView

功能：下拉刷新；上拉加载更多（或滑动到底部自动加载，可自行选择调用）。

该库引用了https://github.com/etsy/AndroidStaggeredGrid/tree/master/library 库

没有上传，请自行下载导入。

#使用须知
1. 默认方式是上拉加载更多
2. 滑动到底部自动加载只需简单的两步：

设置滑动监听

mPullToRefreshStaggeredGridView = (PullToRefreshStaggeredGridView) findViewById(R.id.sgv);
mPullToRefreshStaggeredGridView.setOnRefreshListener(this);
mPullToRefreshStaggeredGridView.setMode(Mode.BOTH);
mPullToRefreshStaggeredGridView.setOnScrollListener(this);（this 是activity 或 fragment）

重写onScroll方法

 @Override
 
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) 
    {
        boolean lastItemVisible = (totalItemCount > 0) && 
        (firstVisibleItem + visibleItemCount >= totalItemCount - 1);
        if (lastItemVisible) {
            mPullToRefreshStaggeredGridView.setPullUpToRefreshing(mPullToRefreshStaggeredGridView);
        }
    }

下拉刷新效果：

![下拉刷新](http://g.recordit.co/QEM5g5fezd.gif)

滑到底部自动加载效果：

![滑到底部自动加载更多](http://g.recordit.co/SWZGTCPiEP.gif)
