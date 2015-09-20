<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color: black; min-height: 80px">
  <!-- 브랜드 -->
  <div class="navbar-header">
    <a class="navbar-brand" href="/product/list" style="color: white;"><h3>커머스서비스</h3></a>
  </div>

  <!-- 좌측메뉴 -->
  <div class="navbar-default sidebar" role="navigation" style="margin-top: 120px;">
    <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
        <li><a href="/product/list"><i class="fa fa-dashboard fa-fw"></i> 상품관리</a></li>
        <li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 주문관리<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a href="/order/list">주문목록</a></li>
            <li><a href="/order/cancel_list">주문취소목록</a></li>
          </ul></li>
      </ul>
    </div>
  </div>
</nav>