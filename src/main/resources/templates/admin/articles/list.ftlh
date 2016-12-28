<#import "/layout/admin/layout.ftlh" as layout>
<@layout.admin "Article" "Danh sách bài viết">
<div class="row">
    <div class="col-lg-12">
        <div class="text-right">
            <a type="button" class="btn btn-primary" href="/admin/articles/create">Thêm mới</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Bài viết</th>
                        <th>-----</th>
                        <th>-----</th>
                    </tr>
                </thead>
                <tbody>
                <#list articles as article>
                <tr class="clickable-row" data-href="/admin/articles/${article.id}">
                    <td>${article.id}</td>
                    <td>${article.title}</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <#else>
                <tr>
                    <td colspan="4">Không có bài viết nào</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
$(document).ready(function() {
    $(".clickable-row").click(function() {
        window.document.location = $(this).data("href");
    });
});
</script>
</@layout.admin>