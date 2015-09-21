<!DOCTYPE html>
<html lang="en">
<%@ include file="/common/header.jsp"%>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Please Sign In</h3>
          </div>
          <div class="panel-body" action="/j_security_check" method="post">
            <form role="form">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Password" name="password" type="password" value="">
                </div>
                <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="/common/scripts.jsp"%>
</body>

</html>
