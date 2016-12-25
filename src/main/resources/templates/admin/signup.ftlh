<#import "/spring.ftl" as spring/>
<#assign title = "Sign Up">
<!DOCTYPE html>
<html lang="en">
<#include "/layout/admin/header.ftlh">
<body>
    <div class="container">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Sign Up</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="post">
                        <@spring.bind "user" />
                        <fieldset>
                            <@spring.bind "user.username" />
                            <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>"">
                                <@spring.formInput "user.username", 'class="form-control" placeholder="Username" name="username" autofocus', "username"/>
                                <@spring.showErrors "<br>", "text-danger" />
                            </div>
                            <@spring.bind "user.email" />
                            <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
                                <@spring.formInput "user.email", 'class="form-control" placeholder="Email" name="email"', "email"/>
                                <@spring.showErrors "<br>", "text-danger" />
                            </div>
                            <@spring.bind "user.password" />
                            <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>"">
                                <input class="form-control" placeholder="Password" name="password" id="password" type="password" value="">
                                <@spring.showErrors "<br>", "text-danger" />
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-lg btn-success btn-block">Sign Up</button>
                            <button type="reset" class="btn btn-lg btn-block" onclick="return resetForm(this.form);">
                                Reset
                            </button>
                        </fieldset>
                    </form>
                    <p>${ipAddress!}</p>
                </div>
            </div>
        </div>
    </div>
    <#include "/layout/admin/footer_scripts.ftlh">
</body>
</html>