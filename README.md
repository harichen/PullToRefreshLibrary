# PullToRefreshLibrary
支持瀑布流的下拉刷新和滑到底部加载更多
=
基于com.handmark.pulltorefresh 和 com.etsy.android.grid.StaggeredGridView 完美实现了上拉加载更多或滑动到底部自动加载两种方式。
该库引用了https://github.com/etsy/AndroidStaggeredGrid/tree/master/library 请自己下载导入。

#使用须知
1. 默认方式是上拉加载更多
2. 滑动到底部自动加载只需简单的两步：

设置滑动监听

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
