Programming language = java

Chose to name component class as Asset because I thought it was confusing to 
call both a specific composite and the component class the same name.

base Composite class is named Asset
AssetManager is the PortfolioManager

when an asset is created it's asset type is added to the end of the assetName
(i.e., -PORTFOLIO, -ACCOUNT, -BOND, -STOCK, -MONEYMARKET)

assets are searched by their full name. so must include -POSTFIX when searching. 

TestAssetManager.java contains the main class. tests the structure and functionality