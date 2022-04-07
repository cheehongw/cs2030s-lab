FILES=cs2030s/fp/*.java
FLAGS=-Xlint:rawtypes
LAB=lab9
.SILENT: all

.SUFFIXES: .java .class
.java.class:
	javac $(FLAGS) $*.java

TEST_CLASSES=Test1.class Test2.class Test3.class Test4.class 
TEST_JSHELLS=test1.jsh test2.jsh test3.jsh test4.jsh 
PACKAGE=\
	cs2030s/fp/Consumer.class\
	cs2030s/fp/Producer.class\
	cs2030s/fp/Transformer.class

Questions.md: Questions.m4 $(FILES) $(TEST_JSHELLS) cs2030s/fp/Try.java
	for i in 1 2 3 4 5 6; do\
	    jshell -q < test$${i}.jsh | sed -f 'clean_for_diff.sed' >  test$${i}.out;\
	done
	m4 Questions.m4 > Questions.md

# jshell -q < ../level$${i}.jsh | sed -f clean.sed > ../level$${i}.out;
test: $(TEST_CLASSES) $(PACKAGE)
	for i in 1 2 3 4; do \
	    echo TEST $${i};\
		javac Test$${i}.java;\
	    java Test$${i};\
	done;
	#java Test > out6.out;\
	#diff out6.out ../output/test6.out

html:
	cd solution; javac $(FLAGS) $(FILES);\
	for i in 1 2 3 4 5; do \
		jshell -R -ea -q $(FILES) < ../level$${i}.jsh | sed -f ../clean_for_html.sed > ../level$${i}.out; \
		jshell -R -ea -q $(FILES) < ../input/test$${i}_1.jsh | sed -f ../clean_for_diff.sed > ../output/test$${i}_1.out; \
	done
	chmod 600 index.shtml index.html
	pandoc --from gfm --to html index.md > index.shtml
	m4 index.shtml > index.html
	chmod 400 index.html index.shtml
	#open index.html


zip:
	cd ..; zip -r $(LAB).zip $(LAB)/

clean:
	rm *.class
