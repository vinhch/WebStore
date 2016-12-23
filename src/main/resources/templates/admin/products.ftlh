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
                    <tr>
                        <td>1</td>
                        <td>Chú chó biết hát</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</@layout.admin>