<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<body>
  <div id="wrapper">
    <%@ include file="/common/menu.jsp"%>
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
            <table class="table table-bordered table-hover table-condensed">
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
                    <td class="text-center"><img src="${product.imageUrl }" width=100 height=100 /></td>
                    <td class="text-center"><a href="view?id=${product.id }">${product.name }</a></td>
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
            <a href="/product/create" class="btn btn-primary btn-sm">Create</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="/common/scripts.jsp"%>
</body>
</html>
