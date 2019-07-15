import json
import pandas as pd
import pymysql
from flask import jsonify 


from flask import Flask
from flask_cors import CORS, cross_origin
app = Flask(__name__)
cors = CORS(app)
app.config["CORS_HEADERS"] = "Content-Type"

def getQuery(cropName):
    if cropName == "beetroot":
        return "select id as \"id\", beet_date as \"date\", beet_price as \"price\", beet_supply as \"supply\" from beetroot"

    if cropName == "bitter":
        return "select id as \"id\", bitter_date as \"date\", bitter_price as \"price\", bitter_supply as \"supply\" from bitter"

    if cropName == "cabbage":
        return "select id as \"id\", cabb_date as \"date\", cabb_price as \"price\", cabb_supply as \"supply\" from cabbage"

    if cropName == "greenchilly":
        return "select gc_date as \"date\", gc_price as \"price\", gc_supply as \"supply\" from greenchilly"

    if cropName == "radish":
        return "select id as \"id\", rad_date as \"date\", rad_piece as \"price\", rad_supply as \"supply\" from radish"


@app.route("/GetCropDetails/<cropName>")
@cross_origin()
def getCrop(cropName):
    dbConn = pymysql.connect(db='fullcrops', user='root', passwd='1234', host='localhost', port=3306)
    cursor = dbConn.cursor()
    recordsList = pd.read_sql_query(getQuery(cropName), dbConn) 
    return jsonify(recordsList.to_dict("records"))

if __name__ == "__main__":
    app.run(port=8082)