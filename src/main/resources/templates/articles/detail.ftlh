<#import "/layout/layout.ftlh" as layout>
<@layout.admin article.title>
<div class="row">
    <div class="box">
        <div class="col-lg-12">
            <h2 class="text-center">${article.title}</h2>
            <div>
                ${article.content}
            </div>
        </div>
    </div>
</div>
</@layout.admin>