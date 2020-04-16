# HUMM Azure & Databrick & ADLS & Spark & Scala

##  Purpose
Because of cooked rices, clothes, rices and money

## First things first, go to microsoft hell
- Registering Microsoft Azure, free trial account (Master,Visa cards)
- Try anything that you feel confident (all very complex and stressful) - [Azure Portal](https://portal.azure.com/), [Azure Cli](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest) ...
- Create ADLS gen2, Databricks (hope you can do it)

## Another hell in paradise
Download or try to beg your mentor to help you on those: 
- Use a cool IDE (seem your only choice is Intellij IDEA)
- Install Azure Plugin
- Install SBT Tool plugin
- Install Scala Plugin

Oh my, cool, create new Azure Spark Scala project with those:

- sbt: 0.13.18 (yes, it was past present and future of us - shit still be shit whenever we touch).
    
    - well, why, because MS guys at databrick don't have time to migrate or upgrade anything outside their project 
- scala: 2.11.12
- spark: 2.4.0 - 6

    - i'm using .0, too lazy to change to .6, so not sure about .6

>Remember that any changes in 3rd versions will creates lot of big compabilities issues so that you can't build, can't import project ... lot of shitty things

### Works, lot of works

- Create databricks service
- Open workspace
- Update your user setting generate the token, write it down into a paper and try to hide it from your child
- Create a new cluster (errr, seem I only got 4 free cores, and minimum workers 2 (each need 4)), shit, so that mean I can't use this to prove anything
    - first errors happend, quota, I don't rich enough for create a minimum cluster, need to back to resource management and try to read through all configuration things that stupid developers of MS gave us (again, fxxk), so, don't dare to choose `southeastasia`, they don't want to help poor, simplemind asia guys (try delete all things you created, and doit again using some rich regions)
    - so, end of the road, re-created everything again, after deleted all, figured out that the `free trial` things that MS giving us only have 4 cores limited, and the minimum databricks cluster need 2 workers mean at least 8 cores. Bye bye. Switching to databricks community portal, god bless me
    - comunity gave me a mini cluster, and not allow me generate a token for access it to code, then good bye again =)))

## Conclusions

1. You can't play with MS Azure for serious things if having no money, so if you don't plan to spend money, stop and walk right away
