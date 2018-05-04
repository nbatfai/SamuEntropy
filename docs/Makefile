all:	clean validate_xmllint_portfolio_hu validate_xmllint_idea_hu validate_xmllint_idea_en validate_xmllint_book_hu validate_xmllint_book_en samuentropy-idea-hu.pdf samuentropy-idea-en.pdf samuentropy-book-hu.pdf samuentropy-book-en.pdf samuentropy_portfolio_hu.pdf

#all:	clean validate_xmllint_idea_en samuentropy-idea-en.pdf

samuentropy-portfolio-hu.pdf: samuentropy-portfolio-hu.xml samuentropy-hu.xls
	dblatex samuentropy-portfolio-hu.xml -p samuentropy-hu.xls

samuentropy-idea-hu.pdf: samuentropy-idea-hu.xml samuentropy-hu.xls
	dblatex samuentropy-idea-hu.xml -p samuentropy-hu.xls

samuentropy-idea-en.pdf: samuentropy-idea-en.xml samuentropy-en.xls
	dblatex samuentropy-idea-en.xml -p samuentropy-en.xls

samuentropy-book-hu.pdf: samuentropy-book-hu.xml samuentropy-hu.xls
	dblatex samuentropy-book-hu.xml -p samuentropy-hu.xls

samuentropy-book-hu.epub: samuentropy-book-hu.xml 
	dbtoepub -o samuentropy-book-hu.epub samuentropy-book-hu.xml

samuentropy-book-en.pdf: samuentropy-book-en.xml samuentropy-en.xls
			dblatex samuentropy-book-en.xml -p samuentropy-en.xls

u12hu:	clean validate_xmllint_book_hu  samuentropy-book-hu.pdf samuentropy-book-hu.epub

pghu:	clean validate_xmllint_idea_hu samuentropy-idea-hu.pdf

porthu:	clean validate_xmllint_portfolio_hu samuentropy-portfolio-hu.pdf

.PHONY: validate_jing_idea_hu
validate_jing_idea_hu:
	xmllint --xinclude samuentropy-idea-hu.xml --output output.xml
	java -jar /home/nbatfai/Downloads/jing-trang-20131210/build/jing.jar -c http://docbook.org/xml/5.0/rng/docbookxi.rnc output.xml

.PHONY: validate_jing_idea_en
validate_jing_idea_en:
	xmllint --xinclude samuentropy-idea-en.xml --output output.xml
	java -jar /home/nbatfai/Downloads/jing-trang-20131210/build/jing.jar -c http://docbook.org/xml/5.0/rng/docbookxi.rnc output.xml

.PHONY: validate_jing_book_hu
validate_jing_book_hu:
	xmllint --xinclude samuentropy-book-hu.xml --output output.xml
	java -jar /home/nbatfai/Downloads/jing-trang-20131210/build/jing.jar -c http://docbook.org/xml/5.0/rng/docbookxi.rnc output.xml

.PHONY: validate_jing_book_en
validate_jing_book_hu:
	xmllint --xinclude samuentropy-book-en.xml --output output.xml
	java -jar /home/nbatfai/Downloads/jing-trang-20131210/build/jing.jar -c http://docbook.org/xml/5.0/rng/docbookxi.rnc output.xml

.PHONY: validate_jing_portfolio_hu
validate_jing_portfolio_hu:
	xmllint --xinclude samuentropy-portfolio-hu.xml --output output.xml
	java -jar /home/batfai/repos/jing-trang/build/jing.jar -c  /usr/share/xml/docbook/schema/rng/5.0/docbookxi.rnc output.xml


.PHONY: validate_xmllint_idea_hu
validate_xmllint_idea_hu:
	xmllint --xinclude samuentropy-idea-hu.xml --output output.xml
	xmllint --relaxng http://docbook.org/xml/5.0/rng/docbookxi.rng output.xml --noout
	rm -f output.xml

.PHONY: validate_xmllint_portfolio_hu
validate_xmllint_portfolio_hu:
	xmllint --xinclude samuentropy-portfolio-hu.xml --output output.xml
	xmllint --relaxng http://docbook.org/xml/5.0/rng/docbookxi.rng output.xml --noout
	rm -f output.xml	
	
.PHONY: validate_xmllint_idea_en
validate_xmllint_idea_en:
	xmllint --xinclude samuentropy-idea-en.xml --output output.xml
	xmllint --relaxng http://docbook.org/xml/5.0/rng/docbookxi.rng output.xml --noout
	rm -f output.xml

.PHONY: validate_xmllint_book_hu
validate_xmllint_book_hu:
	xmllint --xinclude samuentropy-book-hu.xml --output output.xml
	xmllint --relaxng http://docbook.org/xml/5.0/rng/docbookxi.rng output.xml --noout
	rm -f output.xml

.PHONY: validate_xmllint_book_en
validate_xmllint_book_en:
	xmllint --xinclude samuentropy-book-en.xml --output output.xml
	xmllint --relaxng http://docbook.org/xml/5.0/rng/docbookxi.rng output.xml --noout
	rm -f output.xml


.PHONY: clean
clean:
	rm -vf samuentropy-idea-hu.pdf samuentropy-idea-en.pdf samuentropy-book-hu.pdf samuentropy-book-en.pdf samuentropy-book-hu.epub samuentropy-portfolio-hu.pdf
