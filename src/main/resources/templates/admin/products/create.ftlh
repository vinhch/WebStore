<#import "/spring.ftl" as spring/>
<#import "/layout/admin/layout.ftlh" as layout>
<@layout.admin "Sản phẩm" "Thêm mới sản phẩm">
    <form role="form" method="post">
        <@spring.bind "productModel.name" />
        <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
            <label class="control-label" for="name">Tên sản phẩm</label>
            <@spring.formInput "productModel.name", 'class="form-control" name="name"'/>
            <@spring.showErrors "<br>", "text-danger" />
        </div>
        <@spring.bind "productModel.content" />
        <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
            <label class="control-label" for="content">Nội dung</label>
            <@spring.formTextarea "productModel.content", 'class="form-control" name="content" rows="3"'/>
            <@spring.showErrors "<br>", "text-danger" />
        </div>
        <@spring.bind "productModel.price" />
        <div class="form-group <#if spring.status.errorMessages?has_content>has-error</#if>">
            <label class="control-label" for="price">Giá</label>
            <@spring.formInput "productModel.price", 'class="form-control" name="price"'/>
            <@spring.showErrors "<br>", "text-danger" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Lưu</button>
    </form>
</@layout.admin>