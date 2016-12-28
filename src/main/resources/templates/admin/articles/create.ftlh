<#import "/spring.ftl" as spring/>
<#import "/layout/admin/layout.ftlh" as layout>
<@layout.admin "Bài viết" "Thêm mới bài viết">
<form role="form" method="post">
    <@spring.bind "articleModel.title" />
    <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
        <label class="control-label" for="name">Tiêu đề bài viết</label>
        <@spring.formInput "articleModel.title", 'class="form-control" name="name"'/>
        <@spring.showErrors "<br>", "text-danger" />
    </div>
    <@spring.bind "articleModel.content" />
    <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
        <label class="control-label" for="content">Nội dung</label>
        <@spring.formTextarea "articleModel.content", 'class="form-control" name="content" rows="3"'/>
        <@spring.showErrors "<br>", "text-danger" />
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Lưu</button>
</form>
</@layout.admin>