package com.spring3.TextEditor;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class HtmlTextController {

	    @Autowired
	    private TextService textService;

	    @PostMapping("/extract")
	    public String extractText(@RequestParam("htmlContent") String htmlContent, Model model) {
	        String extractedText = textService.extractTextFromHtml(htmlContent);
	        textService.saveTextToFile(extractedText, "C:\\Users\\USER\\storedText.txt");
	        model.addAttribute("text", extractedText);
	        return "result";
	    }
	    
	    @GetMapping("/")
	    public String index(Model m) {
	    	String storedtext=textService.readTextFromFile("C:\\Users\\USER\\storedText.txt");
	    	m.addAttribute("text", storedtext);
	       
	        return "index";
	    }
	    
}
