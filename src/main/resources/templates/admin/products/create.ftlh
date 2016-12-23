<#import "/spring.ftl" as spring/>
<#import "/layout/admin/layout.ftlh" as layout>
<@layout.admin "Sản phẩm" "Thêm mới sản phẩm">
    <form role="form" method="post">
        <@spring.bind "product.name" />
        <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
            <label class="control-label" for="name">Tên sản phẩm</label>
            <@spring.formInput "product.name", 'class="form-control" name="name"'/>
            <@spring.showErrors "<br>", "text-danger" />
        </div>
        <@spring.bind "product.content" />
        <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
            <label class="control-label" for="content">Nội dung</label>
            <@spring.formTextarea "product.content", 'class="form-control" name="content" rows="3"'/>
            <@spring.showErrors "<br>", "text-danger" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Lưu</button>
    </form>
</@layout.admin>