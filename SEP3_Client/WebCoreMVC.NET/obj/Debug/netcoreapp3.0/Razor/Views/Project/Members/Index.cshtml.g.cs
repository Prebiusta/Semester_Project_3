#pragma checksum "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "c93307ef8f3c3f83e34ad15e742ec7c61fb8c905"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Project_Members_Index), @"mvc.1.0.view", @"/Views/Project/Members/Index.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"c93307ef8f3c3f83e34ad15e742ec7c61fb8c905", @"/Views/Project/Members/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"095334c964c978378f687075dd67b876345a8e20", @"/Views/_ViewImports.cshtml")]
    public class Views_Project_Members_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<WebCoreMVC.NET.Models.User>>
    {
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
  
    ViewData["Title"] = "Members";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<!DOCTYPE html>\r\n\r\n<html>\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c93307ef8f3c3f83e34ad15e742ec7c61fb8c9053705", async() => {
                WriteLiteral("\r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/custom.css\">\r\n        <title>Edit Members</title>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c93307ef8f3c3f83e34ad15e742ec7c61fb8c9054786", async() => {
                WriteLiteral("\r\n<h1>Members</h1>\r\n<div class=\"row\">\r\n");
#nullable restore
#line 17 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
         foreach (var item in Model) {

#line default
#line hidden
#nullable disable
                WriteLiteral("            <div class=\"member\">");
#nullable restore
#line 18 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                           Write(item.username);

#line default
#line hidden
#nullable disable
                WriteLiteral("</div>\r\n");
#nullable restore
#line 19 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
        }

#line default
#line hidden
#nullable disable
                WriteLiteral("</div>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n</html>");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<WebCoreMVC.NET.Models.User>> Html { get; private set; }
    }
}
#pragma warning restore 1591
