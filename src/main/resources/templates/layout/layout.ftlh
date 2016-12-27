<#macro admin title="FreeMarker example">
<!DOCTYPE html>
<html lang="en">
<#include "/layout/header.ftlh">
<body>
    <div class="brand">Business Casual</div>
    <div class="address-bar">3481 Melrose Place | Beverly Hills, CA 90210 | 123.456.7890</div>
    
    <!-- Navigation -->
    <#include "/layout/nav.ftlh">
    <!-- /Navigation -->
    
    <!-- Page Content -->
    <div class="container">
        <#nested/>
    </div>
    <!-- /Page Content -->
    <#include "/layout/footer.ftlh">
</body>
</html>
</#macro>