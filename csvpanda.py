# import flask
# from flask import jsonify, url_for , render_template
# from flask_cors import CORS, cross_origin
# import matplotlib.pyplot as plt
# import pymysql
# import json
# from datetime import date
# import pandas as pd
# from pandas import DataFrame
# import matplotlib.pyplot as plt
# import plotly.plotly as py
# import plotly.graph_objs as go
# from plotly.offline import download_plotlyjs, init_notebook_mode,  plot
# from statsmodels.tsa.stattools import adfuller
# import numpy as np
# import math
# from statsmodels.tsa.stattools import acf, pacf
# from statsmodels.tsa.arima_model import ARIMA
# import statsmodels.tsa.holtwinters as ets
# import warnings
# import itertools
# import pandas as pd
# import numpy as np
# import statsmodels.api as sm
# import matplotlib.pyplot as plt
# import matplotlib.pyplot as plt
# import matplotlib.pylab as pylab
# from statsmodels.tsa.api import ExponentialSmoothing, SimpleExpSmoothing, Holt
# app = flask.Flask(__name__)
# CORS(app)
# app.config["DEBUG"] = True

# @app.route('/prediction',methods=['GET']) 
# def home():
# 	li= []
	
	
# 	spy=pd.read_csv("beetroot.csv",parse_dates=['beet_date'],  index_col='beet_date')
# 	spy = spy.fillna(method = 'ffill')
# 	spyt = spy[:'2015-11-02']
# 	spyf = spy['2015-10-31':]
# 	brownt = ets.ExponentialSmoothing(spyt, trend=None, damped = False, seasonal = None).fit()
# 	brownf = brownt.forecast(steps = len(spyf))
# 	brownf = pd.DataFrame(brownf).set_index(spyf.index).dropna()
# 	fig1, ax = plt.subplots()
# 	ax.plot(spyt, label = 'spyt')
# 	ax.plot(spyf, label = 'spyf')
# 	ax.plot(brownf, label = 'brownf')
# 	plt.legend(loc ='upper left')
# 	plt.title('exponential smoothing holt winters')
# 	plt.ylabel('price')
# 	plt.xlabel('date')
# 	li.append(brownf)
# 	ll =[]
	
# 	df = brownf.to_json(orient='records')
	
# 	return df
# if __name__ == "__main__":
#     app.run(port=8082)


# import pandas as pd
# import numpy as np
# import matplotlib.pyplot as plt
# from statsmodels.tsa.holtwinters import ExponentialSmoothing

# df = pd.read_csv('beetroot.csv', 
#                  parse_dates=['beet_date'], 
#                  index_col='beet_date'
# )
# df.index.freq = 'MS'
# train, test = df.iloc[:'2015-11-02'], df.iloc['2015-10-31':]
# model = ExponentialSmoothing(train, seasonal='mul', seasonal_periods=12).fit()
# pred = model.predict(start=test.index[0], end=test.index[-1])

# plt.plot(train.index, train, label='Train')
# plt.plot(test.index, test, label='Test')
# plt.plot(pred.index, pred, label='Holt-Winters')
# plt.legend(loc='best')
import pymysql
import warnings
import itertools
import pandas as pd
import numpy as np
import statsmodels.api as sm
import matplotlib.pyplot as plt
plt.style.use('fivethirtyeight')
conn = pymysql.connect(host='localhost',user='root',password='1234',db='fullcrops1',port=3309)
mycursor = conn.cursor()
# data = "select * from sample"
data = pd.read_csv('beetroot.csv',index_col='beet_date',parse_dates=['beet_date'])
y = data
# y.plot(figsize=(15, 6))
# plt.show()
mod = sm.tsa.statespace.SARIMAX(y,
                                order=(1, 1, 1),
                                seasonal_order=(1, 1, 1, 12),
                                enforce_stationarity=False,
                                enforce_invertibility=False)
results = mod.fit()
pred = results.get_prediction(start=pd.to_datetime('2018-12-12'), dynamic=False)
pred_ci = pred.conf_int()
ax = y['2019':].plot(label='observed')
pred.predicted_mean.plot(ax=ax, label='One-step ahead Forecast', alpha=.7)

ax.fill_between(pred_ci.index,
                pred_ci.iloc[:, 0],
                pred_ci.iloc[:, 1], color='k', alpha=.2)

ax.set_xlabel('Date')
ax.set_ylabel('Price')
plt.legend()
pred_dynamic = results.get_prediction(start=pd.to_datetime('2018-12-12'), dynamic=True, full_results=True)
pred_dynamic_ci = pred_dynamic.conf_int()
ax = y['2019':].plot(label='observed', figsize=(20, 15))
pred_dynamic.predicted_mean.plot(label='Dynamic Forecast', ax=ax)
ax.fill_between(pred_dynamic_ci.index,
                pred_dynamic_ci.iloc[:, 0],
                pred_dynamic_ci.iloc[:, 1], color='k', alpha=.25)

ax.fill_betweenx(ax.get_ylim(), pd.to_datetime('2018-12-12'), y.index[-1],
                 alpha=.1, zorder=-1)

ax.set_xlabel('Date')
ax.set_ylabel('Price')

plt.legend()
plt.show()
# plt.show()
# results.plot_diagnostics(figsize=(15, 12))
# plt.show()
# print(results.summary().tables[1])