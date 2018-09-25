[ ![Download](https://api.bintray.com/packages/vincent-paing/maven/rabbkt/images/download.svg) ](https://bintray.com/vincent-paing/maven/rabbkt/_latestVersion)

# Rabbkt

Rabbkt is a Kotlin implemenation of [Rabbit](https://github.com/Rabbit-Converter/Rabbit) using HashMap as rules instead of parsing json for faster processing. It also allows the user to change the rule easily by providing a generic impelemenation of Rule-Based conversion. 

## Usage

If you use gradle, then include

```
repositories {
    maven {
        url  "https://dl.bintray.com/vincent-paing/maven" 
    }
}

compile 'com.aungkyawpaing:rabbkt:1.0.0'
```

### Conversion

For Zawgyi to Unicode, use 

```RabbktConverter.zawgyiToUnicode(zawgyiString)```

For Unicode to Zawgyi, use

```RabbktConverter.unicodeToZawgyi(unicodeString)```

### Custom Rule

Create an instance of [RuleBasedStringConverter](https://github.com/vincent-paing/Rabbkt/blob/master/src/main/kotlin/converter/RuleBasedStringConverter.kt) by providing a map of Regex and String through its constructor

And then call the convert function with your own instance

```
val myRuleBaseConverter = RuleBasedStringConverter(myRules)
myRuleBaseConverter.convert(yourString)
```


## Credit

- [Rabbit](https://github.com/Rabbit-Converter/Rabbit)
- [Burmese word lists](https://github.com/kanaung/wordlists)


## Licnese

```
DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                   Version 2, December 2004

Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

Everyone is permitted to copy and distribute verbatim or modified
copies of this license document, and changing it is allowed as long
as the name is changed.

           DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
  TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

 0. You just DO WHAT THE FUCK YOU WANT TO.
```
