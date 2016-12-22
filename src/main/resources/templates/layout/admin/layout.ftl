<#macro admin title="FreeMarker example" pageHeader="">
<!DOCTYPE html>
<html lang="en">
<#include "/layout/admin/header.ftl">
<body>
    <div id="wrapper">
        <!-- Navigation -->
        <#include "/layout/admin/nav.ftl">
        <!-- /Navigation -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${pageHeader}</h1>
                </div>
            </div>
            <!-- Content -->
                <#nested/>
            <!-- /Content -->
        </div>
    </div>
    <#include "/layout/admin/footer_scripts.ftl">
</body>
</html>
</#macro>