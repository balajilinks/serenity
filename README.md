
## How to customize this project
 
Edit serenity.properties to make changes specific to your needs.

## Running tests

To run all tests, run the command below:

`$ gradle clean test aggregate`

To run scenarios tagged as pageobject OR screenplay on Chrome: 

`$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dcucumber.options="--tags @pageobject,@screenplay"` 

To run scenarios tagged as ui AND NOT wip on Safari: 
`$ gradle clean test aggregate -Dwebdriver.driver=safari -Dwebdriver.base.url=http://abc.com -Dcucumber.options="--tags @ui --tags ~@wip"`

## Reporting

View the report at target/site/serenity/index.html


