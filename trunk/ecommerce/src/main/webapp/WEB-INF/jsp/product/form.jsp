<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<style>
.top-buffer {
	margin-top: 20px;
}
</style>
<body>
  <div id="wrapper">
    <%@ include file="/common/menu.jsp"%>
    <form:form modelAttribute="product" method="post" id="form" enctype="multipart/form-data">
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">상품</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-1">
            <label>상품명</label>
          </div>
          <div class="col-md-5">
            <form:input path="name" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>컬러</label>
          </div>
          <div class="col-md-5">
            <form:input path="color" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>가격</label>
          </div>
          <div class="col-md-5">
            <form:input path="price" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>이미지</label>
          </div>
          <div class="col-md-5">
            <input type="file" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>설명</label>
          </div>
          <div class="col-md-5">
            <form:textarea path="description" cssClass="form-control input-sm" rows="5" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-12">
            <div class="pull-left">
              <button type="submit" class="btn btn-primary btn-sm">Save</button>
              <a href="/product/list" class="btn btn-default btn-sm">List</a>
              <a href="#" class="btn btn-danger btn-sm">Delete</a>
            </div>
          </div>
        </div>
      </div>
    </form:form>
  </div>
  <%@ include file="/common/scripts.jsp"%>
</body>
</html>
