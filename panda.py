import plotly.plotly as py
import plotly.graph_objs as go

import pandas as pd
import pymysql

# def getQuery(cropName):
#     cropName = "bitter"
#     return "select id as \"id\", bitter_date as \"date\", bitter_price as \"price\", bitter_supply as \"supply\" from bitter"

dbConn = pymysql.connect(db='fullcrops', user='root', passwd='', host='localhost', port=3309)
cursor = dbConn.cursor()
df = pd.read_sql_query(("select id as \"id\", beet_date as \"date\", beet_price as \"price\", beet_supply as \"supply\" from beetroot"), dbConn) 

trace_high = go.Scatter(
    x=df.date,
    y=df['beet_price.High'],
    name = "beet_price High",
    line = dict(color = '#17BECF'),
    opacity = 0.8)

trace_low = go.Scatter(
    x=df.date,
    y=df['beet_price.Low'],
    name = "beet_price Low", 
    line = dict(color = '#7F7F7F'),
    opacity = 0.8)

data = [trace_high,trace_low]

layout = dict(
    title='Time Series with Rangeslider',
    xaxis=dict(
        rangeselector=dict(
            buttons=list([
                dict(count=1,
                     label='1m',
                     step='month',
                     stepmode='backward'),
                dict(count=6,
                     label='6m',
                     step='month',
                     stepmode='backward'),
                dict(step='all')
            ])
        ),
        rangeslider=dict(
            visible = True
        ),
        type='date'
    )
)

fig = dict(data=data, layout=layout)
py.iplot(fig, filename = "Time Series with Rangeslider")