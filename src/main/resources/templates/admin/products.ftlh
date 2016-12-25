<#import "/layout/admin/layout.ftlh" as layout>
<@layout.admin "Products" "Danh sách sản phẩm">
<div class="row">
    <div class="col-lg-12">
        <div class="text-right">
            <a type="button" class="btn btn-primary" href="/admin/products/create">Thêm mới</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Sản phẩm</th>
                        <th>-----</th>
                        <th>-----</th>
                    </tr>
                </thead>
                <tbody>
                <#list products as product>
                    Part repeated for each item
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                    <#else>
                    <tr>
                        <td colspan="4">Không có sản phẩm nào</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</@layout.admin>