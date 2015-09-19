<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/taglibs.jsp"%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>상품관리</title>

<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/metisMenu.min.css" rel="stylesheet">
<link href="/resources/css/timeline.css" rel="stylesheet">
<link href="/resources/css/sb-admin-2.css" rel="stylesheet">
<link href="/resources/css/morris.css" rel="stylesheet">
<link href="/resources/css/font-awesome.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
  <div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
      <!-- 탑메뉴 -->
      <%@ include file="/common/topmenu.jsp"%>
      <!-- 좌측메뉴 -->
      <%@ include file="/common/leftmenu.jsp"%>
    </nav>

    <div id="page-wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">상품목록</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <i class="fa fa-dot-circle-o"> 검색결과 (${page.totalElements}건)</i>
        </div>
        <div class="col-md-12">
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th class="text-center">ID</th>
                  <th class="text-center">이미지</th>
                  <th class="text-center">상품명</th>
                  <th class="text-center">컬러</th>
                  <th class="text-center">가격</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="product" items="${page.content }" varStatus="status">
                  <tr class="odd gradeX">
                    <td class="text-center">${product.id }</td>
                    <td class="text-center">${product.imageUrl }</td>
                    <td class="text-center"><a href="/product/${product.id }">${product.name }</a></td>
                    <td class="text-center">${product.color}</td>
                    <td class="text-center">${product.price }</td>
                  </tr>
                </c:forEach>

              </tbody>
            </table>
          </div>

        </div>
        <div class="col-md-12">
          <ui:pagination page="${page}" />
        </div>
        <div class="col-md-12">
          <div class="pull-right">
            <a href="#" class="btn btn-primary btn-sm">Create</a> <a class="btn btn-danger btn-sm">Delete</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="/common/scripts.jsp"%>
</body>
</html>
