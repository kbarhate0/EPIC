    Dim outobj, mailobj
    Dim f
    Set outobj = CreateObject("Outlook.Application")
    Set mailobj = outobj.CreateItem(0)

    With mailobj
        .To = "kiran.barhate.ext@proximus.com"
        .Subject = "AutomationMailKirqn_New_VDI"
        .Body = "PFA report"
               .Attachments.Add  "C:\Users\Proximus\Desktop\Mobile Automation\WWSGUI_Automation\Reports\ITT\WWS_ITT_TestReport2.html"
        .Send
    End With
    
      'Clear the memory
    Set outobj = Nothing
    Set mailobj = Nothing
